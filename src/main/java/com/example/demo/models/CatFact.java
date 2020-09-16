package com.example.demo.models;

import java.util.Date;

public class CatFact implements Comparable<CatFact>{
    private String text;
    private Date createdAt;
    private Date updatedAt;

    public CatFact(){

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString(){
        return "CatJoke{" + "text='" + text + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    @Override
    public int compareTo(CatFact cf) {
//        if (this.createdAt.before(cf.createdAt)){
//            return -1;
//        } else if(this.createdAt.after(cf.createdAt)){
//            return 1;
//        } else {
//            return 0;
//        }
        return this.getCreatedAt().compareTo(cf.getCreatedAt());
    }
}
