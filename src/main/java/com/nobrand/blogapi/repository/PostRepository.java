package com.nobrand.blogapi.repository;

import com.nobrand.blogapi.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
