package com.flagcamp.backend.service;

import com.flagcamp.backend.entity.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getComments();

    public void saveComment(Comment theComment);

    public Comment getComment(int theId);

    public void deleteComment(int theId);
}
