package com.hopper.restapi.controller;

import com.hopper.restapi.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @GetMapping("/posts")
    public List<Post> getPosts() {
        throw new IllegalArgumentException("Not Yet");
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        throw new IllegalArgumentException("Not Yet");
    }
}
