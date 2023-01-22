package com.example.SocialMediaApp.dto.requests;

import lombok.Data;
@Data
public class CommentUpdateRequest {
        Long id;
        Long userId;
        Long postId;
        String text;
}
