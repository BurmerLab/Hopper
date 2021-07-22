package com.hopper.restapi.controller;

import com.hopper.restapi.service.NewspaperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final NewspaperService newspaperService;

    public Controller(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }

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
