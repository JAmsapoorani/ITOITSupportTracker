package com.ITOTracker.ITOITSupportTracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Priority")
public class Priority {
    @Id
    private Integer priority_id;
    private  String priority_name;


    public Priority() {
    }

    public Priority(Integer priority_id, String priority_name) {
        this.priority_id = priority_id;
        this.priority_name = priority_name;
    }

    public Integer getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(Integer priority_id) {
        this.priority_id = priority_id;
    }

    public  String getPriority_name() {
        return priority_name;
    }

    public void setPriority_name(String priority_name) {
        this.priority_name = priority_name;
    }
}
