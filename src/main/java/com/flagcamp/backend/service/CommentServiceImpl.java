package com.flagcamp.backend.service;

import com.flagcamp.backend.dao.CommentDAO;
import com.flagcamp.backend.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    // need to inject Comment dao
    @Autowired
    private CommentDAO CommentDAO;

    @Override
    @Transactional
    public List<Comment> getComments() {

        return CommentDAO.getComments();
    }

    @Override
    @Transactional
    public void saveComment(Comment theComment) {

        CommentDAO.saveComment(theComment);
    }

    @Override
    @Transactional
    public Comment getComment(int theId) {

        return CommentDAO.getComment(theId);
    }

    @Override
    @Transactional
    public void deleteComment(int theId) {

        CommentDAO.deleteComment(theId);
    }
}





