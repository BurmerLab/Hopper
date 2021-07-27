package com.hopper.restapi.controller;

import com.hopper.restapi.controller.dto.PostDto;
import com.hopper.restapi.model.Post;
import com.hopper.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<PostDto> getAllPosts(@RequestParam(required = false) int page) {
        int pageNumber = page >= 0 ? page : 0;
       return mapToPostDtos(postService.getAllPosts(pageNumber));
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
