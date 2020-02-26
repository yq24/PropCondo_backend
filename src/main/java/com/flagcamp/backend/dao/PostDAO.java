package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Post;

import java.util.List;

public interface PostDAO {

    public List<Post> getPosts();

    public void savePost(Post thePost);

    public Post getPost(int theId);

    public void deletePost(int theId);

}