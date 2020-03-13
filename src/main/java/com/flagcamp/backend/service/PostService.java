package com.flagcamp.backend.service;

import com.alibaba.fastjson.JSONArray;
import com.flagcamp.backend.entity.Post;

import java.util.List;

public interface PostService {
    public JSONArray getPosts();

    public void savePost(Post thePost);

    public Post getPost(int theId);

    public void deletePost(int theId);
}