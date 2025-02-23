package com.example.hikes.service;

import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.exception.NotFoundException;
import com.example.hikes.exception.UnauthorizedException;
import com.example.hikes.mapper.CommentMapper;
import com.example.hikes.model.Comment;
import com.example.hikes.model.Hike;
import com.example.hikes.model.User;
import com.example.hikes.repository.CommentRepository;
import com.example.hikes.repository.HikeRepository;
import com.example.hikes.repository.UserRepository;
import com.example.hikes.util.JwtTokenUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HikeRepository hikeRepository;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public void createComment(CreateCommentRequestDTO createCommentRequestDTO, String accessToken){
        if(accessToken == null){
            throw new UnauthorizedException("Unauthorized");
        }

        ObjectId userId;
        try{
            userId = new ObjectId(jwtTokenUtil.getUserId(accessToken));
        }catch(Exception ex){
            throw new UnauthorizedException("Unauthorized");
        }

        Hike hike = hikeRepository.findById(createCommentRequestDTO.getHikeId()).orElse(null);
        if (hike != null){
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UnauthorizedException("Unauthorized"));

            Comment comment = commentRepository.insert(commentMapper.toDocument(createCommentRequestDTO, user));

            mongoTemplate.update(Hike.class)
                    .matching(Criteria.where("name").is(hike.getName()))
                    .apply(new Update().push("commentIds").value(comment))
                    .first();
        }else{
            throw new NotFoundException("Hike not found.");
        }




    }
}
