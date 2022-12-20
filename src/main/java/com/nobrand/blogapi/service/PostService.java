package com.nobrand.blogapi.service;

import com.nobrand.blogapi.domain.Post;
import com.nobrand.blogapi.repository.PostRepository;
import com.nobrand.blogapi.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate request) {
        Post post = new Post(request.getTitle(), request.getContent());
        log.info(post.toString());

        postRepository.save(post);
    }
}
