package com.example.SocialMediaApp.services.post;

import com.example.SocialMediaApp.dto.requests.PostCreateRequest;
import com.example.SocialMediaApp.dto.requests.PostUpdateRequest;
import com.example.SocialMediaApp.entities.Post;
import com.example.SocialMediaApp.entities.User;
import com.example.SocialMediaApp.repos.PostRepository;
import com.example.SocialMediaApp.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostServiceImp(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post createPost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUser(newPostRequest.getUserId());
        if (user == null) {
            return null;
        }
        Post post = new Post();
        post.setId(newPostRequest.getId());
        post.setTitle(newPostRequest.getTitle());
        post.setText(newPostRequest.getText());
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, PostUpdateRequest postUpdateRequest) {
        Optional<Post> availablePost = postRepository.findById(id);
        if (availablePost.isPresent()) {
            Post post = availablePost.get();
            post.setText(postUpdateRequest.getText());
            post.setTitle(postUpdateRequest.getTitle());
            postRepository.save(post);
            return post;
        }
        return null;
    }
}

