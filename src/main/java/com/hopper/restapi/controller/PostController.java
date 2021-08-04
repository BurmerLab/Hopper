package com.hopper.restapi.controller;

import com.hopper.restapi.controller.dto.PostDto;
import com.hopper.restapi.model.Post;
import com.hopper.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hopper.restapi.controller.dto.PostDtoMapper.mapToPostDtos;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
       return postService.getPosts();
    }

    @GetMapping("/findPost")
    public List<PostDto> getAllPosts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = (page != null && page >= 0) ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;

       return mapToPostDtos(postService.getSortedPostsByPageNumber(pageNumber, sortDirection));
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }
}
