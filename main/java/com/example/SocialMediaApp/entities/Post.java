package com.example.SocialMediaApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //ilgili user silinirse tum postları silinsin.
    @JsonIgnore
    private User user;

    private String title;

    @Lob
    @Column(columnDefinition = "text") //default varchar(255)
    private String text;
}
