package com.example.hikes.controller;

import com.example.hikes.dto.request.reply.CreateReplyRequestDTO;
import com.example.hikes.service.ReplyService;
import com.example.hikes.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/reply")
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping
    public ResponseEntity<String> createReply(@RequestBody @Valid CreateReplyRequestDTO createReplyRequestDTO, BindingResult bindingResult, HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed");
        }

        String accessToken = CookieUtil.getCookieValue(request,"accessToken");

        replyService.createReply(createReplyRequestDTO, accessToken);
        return ResponseEntity.ok("Reply created successfully");
    }
}
