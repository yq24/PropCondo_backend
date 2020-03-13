package com.flagcamp.backend.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flagcamp.backend.entity.Comment;
import com.flagcamp.backend.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public JSONArray getPosts() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by id
        Query<Post> theQuery =
                currentSession.createQuery("from Post order by post_id",
                        Post.class);

        // execute query and get result list
        List<Post> Posts = theQuery.getResultList();

        JSONArray ans = new JSONArray();
        for (Post post : Posts) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("postId",post.getPost_id());
            jsonObject.put("postUser",post.getUser_id());
            jsonObject.put("postTime",post.getTime());
            jsonObject.put("postTest",post.getText());
            jsonObject.put("postImage",post.getImage_url());
            jsonObject.put("postAnonymous",post.isAnonymous());
            //添加comment
            List<Comment> comments = commentDAO.getComments(post.getPost_id());
            jsonObject.put("comments", comments);
            ans.add(jsonObject);
        }
        // return the results
        return ans;
    }

    @Override
    public void savePost(Post thePost) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();


        currentSession.saveOrUpdate(thePost);

    }

    @Override
    public Post getPost(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Post thePost = currentSession.get(Post.class, theId);

        return thePost;
    }

    @Override
    public void deletePost(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Post where post_id =:PostId");
        theQuery.setParameter("PostId", theId);

        theQuery.executeUpdate();
    }

}
