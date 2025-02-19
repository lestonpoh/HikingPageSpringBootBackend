package com.example.hikes.service;

import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.mapper.CommentMapper;
import com.example.hikes.model.Comment;
import com.example.hikes.model.Hike;
import com.example.hikes.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    MongoTemplate mongoTemplate;

    public Comment createComment(CreateCommentRequestDTO createCommentRequestDTO){
        Comment comment = commentRepository.insert(commentMapper.toDocument(createCommentRequestDTO));

        mongoTemplate.update(Hike.class)
                .matching(Criteria.where("name").is(createCommentRequestDTO.getHikeName()))
                .apply(new Update().push("commentIds").value(comment))
                .first();

        return comment;
    }
}
