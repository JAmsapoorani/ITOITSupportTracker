package com.ITOTracker.ITOITSupportTracker.entity;

import com.ITOTracker.ITOITSupportTracker.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="viewticket")
@NoArgsConstructor
public class ViewTicket  {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticket_id;
    private  Integer assignee_Id;
    private String subjects ;
    private String description ;

    @ManyToOne
    @JoinColumn(name = "status_id" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Status status;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Sub_Category sub_category;


    public ViewTicket(Integer ticket_id, Integer assignee_Id, String subjects, String description, Status status, Priority priority, Category category, Sub_Category sub_category, String url_link) {
        this.ticket_id = ticket_id;
        this.assignee_Id = assignee_Id;
        this.subjects = subjects;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.category = category;
        this.sub_category = sub_category;
        this.url_link = url_link;
    }

    private  String url_link="http://localhost:8183/api/usermodule";

    public Sub_Category getSub_category() {
        return sub_category;
    }

    public Category getCategory() {
        return category;
    }


    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory(Category category) {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Sub_Category getSub_category(Sub_Category sub_category) {
        return this.sub_category;
    }

    public void setSub_category(Sub_Category sub_category) {
        this.sub_category = sub_category;
    }

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }


}
