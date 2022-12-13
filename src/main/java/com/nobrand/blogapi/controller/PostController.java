package com.nobrand.blogapi.controller;

import com.nobrand.blogapi.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
public class PostController {

    @PostMapping("v1/post")
    public Map<String, String> post(@ModelAttribute PostCreate postCreate) {
        log.info(postCreate.toString());
        return Map.of();
    }

    @PostMapping("/v2/post")
    public Map<String, String> postJson(@RequestBody @Valid PostCreate postCreate, BindingResult bindingResult) {
        log.info(postCreate.toString());

        Map<String, String> response = new java.util.HashMap<>(Map.of());
        if (bindingResult.hasErrors()) {
            for (FieldError e: bindingResult.getFieldErrors()) {
                response.put(e.getField(), e.getDefaultMessage());
            }
        }
        return response;
    }

}
