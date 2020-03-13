package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Comment> getComments() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by id
        Query<Comment> theQuery =
                currentSession.createQuery("from Comment order by comment_id",
                        Comment.class);

        // execute query and get result list
        List<Comment> comments = theQuery.getResultList();

        // return the results
        return comments;
    }

    @Override
    public List<Comment> getComments(int postid) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by id
        Query<Comment> theQuery = currentSession.createQuery("from Comment where post_id =: postId", Comment.class);
        theQuery.setParameter("postId", postid);

        // execute query and get result list
        List<Comment> comments = theQuery.getResultList();

        // return the results
        return comments;
    }

    @Override
    public void saveComment(Comment theComment) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the customer ... finally LOL
        currentSession.saveOrUpdate(theComment);

    }

    @Override
    public Comment getComment(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Comment theComment = currentSession.get(Comment.class, theId);

        return theComment;
    }

    @Override
    public void deleteComment(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Comment where comment_id =:commentId");
        theQuery.setParameter("commentId", theId);

        theQuery.executeUpdate();
    }

}











