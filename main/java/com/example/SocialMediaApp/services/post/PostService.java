package com.example.SocialMediaApp.services.post;

import com.example.SocialMediaApp.dto.requests.PostCreateRequest;
import com.example.SocialMediaApp.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts(Optional<Long> userId);

    Post getPostById(Long postId);

    Post createPost(PostCreateRequest newPostRequest);
}
