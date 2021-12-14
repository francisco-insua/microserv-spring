package com.restfulwebservice.restfulwebservice.post;


import java.util.Date;

public class Post {

    private Integer userId;
    private Integer id;
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Post(Integer id, Integer userId, Date date) {
        this.id = id;
        this.userId = userId;
        this.createdDate = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
