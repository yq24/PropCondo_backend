package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Comment;

import java.util.List;

public interface CommentDAO {

    public List<Comment> getComments();

    public void saveComment(Comment theComment);

    public Comment getComment(int theId);

    public void deleteComment(int theId);

}