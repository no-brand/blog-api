package com.nobrand.blogapi.controller;

import com.nobrand.blogapi.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostController {

    @PostMapping("v1/post")
    public String post(@ModelAttribute PostCreate postCreate) {
        log.info(postCreate.toString());
        return "ModelAttribute";
    }

    @PostMapping("/v2/post")
    public String postJson(@RequestBody PostCreate postCreate) {
        log.info(postCreate.toString());
        return "RequestBody";
    }

}
