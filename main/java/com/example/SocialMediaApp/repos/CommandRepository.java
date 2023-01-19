package com.example.SocialMediaApp.repos;

import com.example.SocialMediaApp.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command,Long> {
}
