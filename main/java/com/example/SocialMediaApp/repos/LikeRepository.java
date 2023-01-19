package com.example.SocialMediaApp.repos;

import com.example.SocialMediaApp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
