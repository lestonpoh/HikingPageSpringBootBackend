package com.example.hikes.service;

import com.example.hikes.dto.request.reply.CreateReplyRequestDTO;
import com.example.hikes.mapper.ReplyMapper;
import com.example.hikes.model.Comment;
import com.example.hikes.model.Hike;
import com.example.hikes.model.Reply;
import com.example.hikes.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createReply(CreateReplyRequestDTO createReplyRequestDTO){
        Reply reply = replyRepository.insert(replyMapper.toDocument(createReplyRequestDTO));

        mongoTemplate.update(Comment.class)
                .matching(Criteria.where("id").is(createReplyRequestDTO.getCommentId()))
                .apply(new Update().push("replyIds").value(reply))
                .first();

    }
}
