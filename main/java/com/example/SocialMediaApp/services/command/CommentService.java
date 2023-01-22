package com.example.SocialMediaApp.services.command;

import com.example.SocialMediaApp.dto.requests.CommentCreateRequest;
import com.example.SocialMediaApp.dto.requests.CommentUpdateRequest;
import com.example.SocialMediaApp.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAllCommentWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment getACommentById(Long commentId);

    Comment createComment(CommentCreateRequest commentCreateRequest);

    Comment updateComment(Long commentId,CommentUpdateRequest commentUpdateRequest);

    void deleteCommentById(Long commentId);
}
