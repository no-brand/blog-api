package com.nobrand.blogapi.controller;

import com.nobrand.blogapi.request.PostCreate;
import com.nobrand.blogapi.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("v1/post")
    public Map<String, String> post(@ModelAttribute PostCreate postCreate) {
        log.info(postCreate.toString());
        return Map.of();
    }

    @PostMapping("/v2/post")
    public Map<String, String> postJson(@RequestBody @Valid PostCreate postCreate) {
        log.info(postCreate.toString());

        postService.write(postCreate);
        Map<String, String> response = new java.util.HashMap<>(Map.of());
        return response;
    }

}
