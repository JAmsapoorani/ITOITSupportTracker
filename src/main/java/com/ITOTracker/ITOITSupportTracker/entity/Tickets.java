package com.ITOTracker.ITOITSupportTracker.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@SuppressWarnings("ALL")
@Entity
@NoArgsConstructor
@Table(name= "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer ticket_id;
    @Column(name="category_id")
    private Integer category_id;
    @Column(name="sub_category_id")
    private  Integer sub_category_id;
    private  Integer assignee_Id;
    @Column(name="user_id")
    private Integer user_id;
    private String subjects ;
    private String description ;
    @Column(name="status_id")
    private Integer status_id;
    @Column(name="priority_id")
    private Integer priority_id;
    private LocalDateTime create_datetime;
    @Column(name = "reported_id")
    private Integer reported_id;
    private  LocalDateTime last_modified_datetime;

    public LocalDateTime getLast_modified_datetime() {
        return last_modified_datetime;
    }

    public void setLast_modified_datetime(LocalDateTime last_modified_datetime) {
        this.last_modified_datetime = last_modified_datetime;
    }

    public Integer getReported_id() {
        return reported_id;
    }

    public void setReported_id(Integer reported_id) {
        this.reported_id = reported_id;
    }

    private  String url_link="http://localhost:8183/api/usermodule";

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public  Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(Integer sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public Integer getAssignee_Id() {
        return assignee_Id;
    }

    public void setAssignee_Id(Integer assignee_Id) {
        this.assignee_Id = assignee_Id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public  String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(Integer priority_id) {
        this.priority_id = priority_id;
    }

    public LocalDateTime getCreate_datetime() {
        return create_datetime;
    }

    public void setCreate_datetime(LocalDateTime create_datetime) {
        this.create_datetime = create_datetime;
    }

    public Tickets(Integer ticket_id, Integer category_id, Integer sub_category_id, Integer assignee_Id, Integer user_id, String subjects, String description, Integer status_id, Integer priority_id, LocalDateTime create_datetime) {
        this.ticket_id = ticket_id;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.assignee_Id = assignee_Id;
        this.user_id = user_id;
        this.subjects = subjects;
        this.description = description;
        this.status_id = status_id;
        this.priority_id = priority_id;
        this.create_datetime = create_datetime;
    }
}
