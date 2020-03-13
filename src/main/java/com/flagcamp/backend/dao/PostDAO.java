package com.flagcamp.backend.dao;

import com.alibaba.fastjson.JSONArray;
import com.flagcamp.backend.entity.Post;

import java.util.List;

public interface PostDAO {

    public JSONArray getPosts();

    public void savePost(Post thePost);

    public Post getPost(int theId);

    public void deletePost(int theId);

}