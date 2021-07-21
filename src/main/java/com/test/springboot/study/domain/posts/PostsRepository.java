package com.test.springboot.study.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // named sql
    @Query("SELECT p FROM Posts  as p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}


//PostsListResponseDto