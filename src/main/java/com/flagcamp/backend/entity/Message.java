package com.flagcamp.backend.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "user_from")
    private String userFrom;

    @Column(name = "user_to")
    private Date userTo;

    @Column(name = "time")
    private Date time;

    @Column(name = "image")
    private String image;

    @Column(name = "text")
    private String text;

    public Message() {

    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public Date getUserTo() {
        return userTo;
    }

    public void setUserTo(Date userTo) {
        this.userTo = userTo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", userFrom='" + userFrom + '\'' +
                ", userTo=" + userTo +
                ", time=" + time +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

};