package com.ITOTracker.ITOITSupportTracker.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Comment")
@NoArgsConstructor
public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer comment_id;
        private Integer ticket_id;
        private Integer user_id;
        private String message;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
