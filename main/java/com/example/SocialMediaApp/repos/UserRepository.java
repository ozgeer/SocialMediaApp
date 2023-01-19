package com.example.SocialMediaApp.repos;

import com.example.SocialMediaApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
