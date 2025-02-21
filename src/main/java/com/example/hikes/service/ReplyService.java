package com.example.hikes.service;

import com.example.hikes.dto.request.reply.CreateReplyRequestDTO;
import com.example.hikes.exception.NotFoundException;
import com.example.hikes.exception.UnauthorizedException;
import com.example.hikes.mapper.ReplyMapper;
import com.example.hikes.model.Comment;
import com.example.hikes.model.Reply;
import com.example.hikes.model.User;
import com.example.hikes.repository.CommentRepository;
import com.example.hikes.repository.ReplyRepository;
import com.example.hikes.repository.UserRepository;
import com.example.hikes.util.JwtTokenUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public void createReply(CreateReplyRequestDTO createReplyRequestDTO, String accessToken){
        if(accessToken == null){
            throw new UnauthorizedException("Unauthorized");
        }

        ObjectId userId;
        try{
            userId = new ObjectId(jwtTokenUtil.getUserId(accessToken));
        }catch(Exception ex){
            throw new UnauthorizedException("Unauthorized");
        }

        if (commentRepository.existsById(createReplyRequestDTO.getCommentId())){
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UnauthorizedException("Unauthorized"));

            Reply reply = replyRepository.insert(replyMapper.toDocument(createReplyRequestDTO, user));

            mongoTemplate.update(Comment.class)
                    .matching(Criteria.where("id").is(createReplyRequestDTO.getCommentId()))
                    .apply(new Update().push("replyIds").value(reply))
                    .first();
        }else{
            throw new NotFoundException("Comment not found");
        }



    }
}
