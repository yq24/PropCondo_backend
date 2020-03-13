package com.flagcamp.backend.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="post_id")
    private int post_id;

    @Column(name="user_id")
    private String user_id;

    @Column(name="time")
    private Date time;

    @Column(name="text")
    private String text;

    @Column(name="image_url")
    private String image_url;

    @Column(name="anonymous")
    private boolean anonymous;

    public Post() {

    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", user_id=" + user_id +
                ", time=" + time +
                ", text='" + text + '\'' +
                ", image_url='" + image_url + '\'' +
                ", anonymous=" + anonymous +
                '}';
    }
}
