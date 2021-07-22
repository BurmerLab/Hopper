package com.hopper.restapi.controller;

import com.hopper.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final PostService newspaperService;

    @GetMapping("/")
    public String hello() {
        return newspaperService.getHello();
    }

    /*Injection types:
    1) @Autowired on field
    2) @Autowired on setter of field
    3) Constructor with or without @Autowired or Lombok @RequiredArgsConstructor
    */
}
