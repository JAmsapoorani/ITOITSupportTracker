package com.ITOTracker.ITOITSupportTracker.entity;

import com.ITOTracker.ITOITSupportTracker.entity.Category;
import com.ITOTracker.ITOITSupportTracker.entity.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="viewticket")
public class ViewTicketList  {
    @Id
    private  Integer ticket_id;
    private String category_desc;
    private  String sub_category_desc;
    private  Integer assignee_Id;
    private String subjects ;
    private String priority_name;
    private String status_name;
    private  String url_link;
    private  Integer user_id;
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }

    public String getSub_category_desc() {
        return sub_category_desc;
    }

    public void setSub_category_desc(String sub_category_desc) {
        this.sub_category_desc = sub_category_desc;
    }

    public Integer getAssignee_Id() {
        return assignee_Id;
    }

    public void setAssignee_Id(Integer assignee_Id) {
        this.assignee_Id = assignee_Id;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getPriority_name() {
        return priority_name;
    }

    public void setPriority_name(String priority_name) {
        this.priority_name = priority_name;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }
}
