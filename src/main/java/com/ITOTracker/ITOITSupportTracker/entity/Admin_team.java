package com.ITOTracker.ITOITSupportTracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Admin_team")
public class Admin_team {
    @Id
    private Integer admin_id;
    @Column(name = "name")
    private String name;
    @Column(name = "emailId")
    private String emailId;

    public Admin_team(Integer admin_id, String name, String emailId) {
        this.admin_id = admin_id;
        this.name = name;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Admin_team{" +
                "admin_id=" + admin_id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    public Admin_team() {
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
