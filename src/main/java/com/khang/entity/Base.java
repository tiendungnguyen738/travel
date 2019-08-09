package com.khang.entity;

import javax.persistence.*;

@MappedSuperclass // cha cua cac entity
public class Base {
    @Id //danh dau day la khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tu sinh
    @Column(columnDefinition = "int")// int(4)
    private long id;
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public Base(long id){
        this.id = id;
    }
}
