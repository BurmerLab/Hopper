package com.hopper.restapi.service;

import com.hopper.restapi.model.Post;
import com.hopper.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_MAX_SIZE = 20;
    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getSortedPostsByPageNumber(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_MAX_SIZE, Sort.by(sort, "id")));
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow();
    }

    public String getHello() {
        return "Hello Service";
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional //grouping to one transaction for whole db transactions in method (here for findById and save)
    public Post editPost(Post post) {
        Post editedPost = postRepository.findById(post.getId()).orElseThrow();
        editedPost.setTitle(post.getTitle());
        editedPost.setContent(post.getTitle());
//        return postRepository.save(editedPost);
        return editedPost; // not need to make JPA save() because entity was modified and Hibernate know it.
    }
}
