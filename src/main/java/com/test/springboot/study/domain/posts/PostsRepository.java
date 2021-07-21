package com.test.springboot.study.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// named sql
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts AS p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
