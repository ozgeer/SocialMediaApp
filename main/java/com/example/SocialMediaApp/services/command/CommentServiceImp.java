package com.example.SocialMediaApp.services.command;

import com.example.SocialMediaApp.dto.requests.CommentCreateRequest;
import com.example.SocialMediaApp.dto.requests.CommentUpdateRequest;
import com.example.SocialMediaApp.entities.Comment;
import com.example.SocialMediaApp.entities.Post;
import com.example.SocialMediaApp.entities.User;
import com.example.SocialMediaApp.repos.CommentRepository;
import com.example.SocialMediaApp.services.post.PostService;
import com.example.SocialMediaApp.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    @Override
    public List<Comment> getAllCommentWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else return commentRepository.findAll();

    }

    @Override
    public Comment getACommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getAUserById(commentCreateRequest.getUserId());
        Post post = postService.getPostById(commentCreateRequest.getPostId());
        if (user != null && post != null) {
            Comment comment = new Comment();
            comment.setId(commentCreateRequest.getId());
            comment.setUser(user);
            comment.setPost(post);
            comment.setText(commentCreateRequest.getText());
            return commentRepository.save(comment);
        } else return null;
    }

    @Override
    public Comment updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> variableComment=commentRepository.findById(commentId);
        if(variableComment.isPresent()){
            Comment comment=variableComment.get();
            comment.setText(commentUpdateRequest.getText());
            return commentRepository.save(comment);
        }
        else
            return  null;
    }

    @Override
    public void deleteCommentById(Long commentId){
        commentRepository.deleteById(commentId);
    }
}


