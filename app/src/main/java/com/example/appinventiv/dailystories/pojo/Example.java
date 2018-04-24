package com.example.appinventiv.dailystories.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by appinventiv on 18/4/18.
 */

public class Example {

    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("kids")
    @Expose
    private ArrayList<Integer> kids = null;
    @SerializedName("parent")
    @Expose
    private Integer parent;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("type")
    @Expose
    private String type;
    public String getBy() {
        return by;
    }
    public void setBy(String by) {
        this.by = by;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public ArrayList<Integer> getKids() {
        return kids;
    }
    public void setKids(ArrayList<Integer> kids) {
        this.kids = kids;
    }
    public Integer getParent() {
        return parent;
    }
    public void setParent(Integer parent) {
        this.parent = parent;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getTime() { return time; }
    public void setTime(Integer time) { this.time = time; }
    public String getType() { return type; }
    public void setType(String type) {
        this.type = type;
    }
}
