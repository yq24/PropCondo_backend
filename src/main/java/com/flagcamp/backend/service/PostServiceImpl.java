package com.flagcamp.backend.service;

import com.flagcamp.backend.dao.PostDAO;
import com.flagcamp.backend.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    // need to inject Post dao
    @Autowired
    private PostDAO PostDAO;

    @Override
    @Transactional
    public List<Post> getPosts() {

        return PostDAO.getPosts();
    }

    @Override
    @Transactional
    public void savePost(Post thePost) {

        PostDAO.savePost(thePost);
    }

    @Override
    @Transactional
    public Post getPost(int theId) {

        return PostDAO.getPost(theId);
    }

    @Override
    @Transactional
    public void deletePost(int theId) {

        PostDAO.deletePost(theId);
    }
}






