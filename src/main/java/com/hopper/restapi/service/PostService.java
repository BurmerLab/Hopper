package com.hopper.restapi.service;

import com.hopper.restapi.model.Post;
import com.hopper.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_MAX_SIZE = 20;
    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPosts(int page) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_MAX_SIZE));
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow();
    }

    public String getHello() {
        return "Hello Service";
    }

}
