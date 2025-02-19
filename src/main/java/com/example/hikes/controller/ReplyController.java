package com.example.hikes.controller;

import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.dto.request.reply.CreateReplyRequestDTO;
import com.example.hikes.model.Comment;
import com.example.hikes.model.Reply;
import com.example.hikes.service.CommentService;
import com.example.hikes.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping
    public ResponseEntity<Reply> createReply(@RequestBody CreateReplyRequestDTO createReplyRequestDTO){
        return new ResponseEntity<Reply>(replyService.createReply(createReplyRequestDTO), HttpStatus.OK);
    }
}
