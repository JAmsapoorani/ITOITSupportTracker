package com.ITOTracker.ITOITSupportTracker.entity;

import javax.persistence.*;


@Entity
@Table(name = "Sub_Category")
public class  Sub_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sub_category_id")
    private Integer  sub_category_id;

    private Integer category_id;


    @Column(name = "sub_category_desc")
    private  String sub_category_desc;


    public Sub_Category() {
    }

    public Sub_Category(Integer sub_category_id,Integer Category_id, String sub_category_desc) {
        this.sub_category_id = sub_category_id;
        this.category_id =Category_id;
        this.sub_category_desc = sub_category_desc;
    }

    @Override
    public String toString() {
        return "Sub_Category{" +
                "sub_category_id=" + sub_category_id +
                ", category_id=" + category_id +
                ", sub_category_desc='" + sub_category_desc + '\'' +
                '}';
    }

    public Integer getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(Integer sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getSub_category_desc() {
        return sub_category_desc;
    }

    public void setSub_category_desc(String sub_category_desc) {
        this.sub_category_desc = sub_category_desc;
    }



}
