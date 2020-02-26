package com.flagcamp.backend.rest;

import com.flagcamp.backend.entity.Comment;
import com.flagcamp.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @GetMapping("/comments/{commentId}")
    public Comment getComment(@PathVariable int commentId) {
        Comment theComment = commentService.getComment(commentId);
        if (theComment == null) {
            throw new CommentNotFoundException("Comment id not found - " + commentId);
        }
        return theComment;
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment theComment) {
        theComment.setComment_id(0);   //hardcode

        commentService.saveComment(theComment);

        return theComment;
    }

    @PutMapping("/comments")
    public Comment updateComment(@RequestBody Comment theComment) {
        commentService.saveComment(theComment);
        return theComment;
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        Comment tempComment = commentService.getComment(commentId);
        if (tempComment == null) {
            throw new CommentNotFoundException("Comment id not found - " + commentId);
        }
        commentService.deleteComment(commentId);
        return "Deleted Comment id - " + commentId;
    }

}
