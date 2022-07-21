package com.ITOTracker.ITOITSupportTracker.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User  {

    @Id
    private Integer user_id;
    @Column(name = "user_name")
    private String user_name;

    @Column(name = "emailId")
    private String email_id;

    public User(Integer user_id, String user_name, String email_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email_id = email_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", name='" + user_name + '\'' +
                ", email_id='" + email_id + '\'' +
                '}';
    }

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
