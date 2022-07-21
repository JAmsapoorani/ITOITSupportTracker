package com.ITOTracker.ITOITSupportTracker.entity;

import javax.persistence.*;
@Entity
@Table(name = "Category")
public class Category {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private Integer category_id;
    @Column(name = "category_desc")
    private  String category_desc;


    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public  String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }
}
