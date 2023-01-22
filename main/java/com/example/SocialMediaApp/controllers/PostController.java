package com.example.SocialMediaApp.controllers;

import com.example.SocialMediaApp.dto.requests.PostCreateRequest;
import com.example.SocialMediaApp.dto.requests.PostUpdateRequest;
import com.example.SocialMediaApp.entities.Post;
import com.example.SocialMediaApp.services.post.PostService;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@NoArgsConstructor
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    }
    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createPost(@RequestBody  PostCreateRequest newPostRequest){
        return postService.createPost(newPostRequest);
    }

    @PutMapping
    public Post updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest){
    return postService.updatePost(id,postUpdateRequest);
    }
}
