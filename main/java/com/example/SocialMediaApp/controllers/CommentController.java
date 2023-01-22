package com.example.SocialMediaApp.controllers;

import com.example.SocialMediaApp.dto.requests.CommentCreateRequest;
import com.example.SocialMediaApp.dto.requests.CommentUpdateRequest;
import com.example.SocialMediaApp.entities.Comment;
import com.example.SocialMediaApp.services.command.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                        @RequestParam Optional<Long> postId){
        return commentService.getAllCommentWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getACommentById(@PathVariable Long commentId){
        return commentService.getACommentById(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createComment(commentCreateRequest);
    }

    @PutMapping("/{commentId}")
        public Comment updateComment(@PathVariable Long commentId,
            @RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateComment(commentId,commentUpdateRequest);
        }

        @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
        }
    }

