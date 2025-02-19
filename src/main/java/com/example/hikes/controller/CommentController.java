package com.example.hikes.controller;

import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.model.Comment;
import com.example.hikes.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CreateCommentRequestDTO createCommentRequestDTO){
        return new ResponseEntity<>(commentService.createComment(createCommentRequestDTO), HttpStatus.OK);
    }

}
