package com.hopper.restapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.action.internal.OrphanRemovalAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will be automatically generated for that field
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;


//    @OneToMany(orphanRemoval = true)// orphanRemoval- delete comment when updating Post with post_id joined and post_id is null
    @OneToMany
    @JoinColumn(name = "post_id", updatable = false, insertable = false) //DB column name, if in Comments.java would be field postId then should be postId here
    //updatable and insertable do not insert or update comments during change Post
    private List<Comment> comments;
}
