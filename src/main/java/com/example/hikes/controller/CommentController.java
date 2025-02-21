package com.example.hikes.controller;

import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.model.Comment;
import com.example.hikes.service.CommentService;
import com.example.hikes.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<String> createComment(@RequestBody @Valid CreateCommentRequestDTO createCommentRequestDTO, BindingResult bindingResult, HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed");
        }

        String accessToken = CookieUtil.getCookieValue(request,"accessToken");

        commentService.createComment(createCommentRequestDTO, accessToken);
        return ResponseEntity.ok().body("Comment created successfully.");
    }

}
