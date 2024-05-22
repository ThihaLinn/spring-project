package com.example.streamingappbackend.dao;

import com.example.streamingappbackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
