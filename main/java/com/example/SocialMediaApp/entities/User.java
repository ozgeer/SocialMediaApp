package com.example.SocialMediaApp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user-id",nullable = false)
    private Long id;

    @Column(name = "user-name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

}
