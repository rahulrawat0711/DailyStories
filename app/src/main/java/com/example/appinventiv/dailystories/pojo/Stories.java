package com.example.appinventiv.dailystories.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Stories implements Parcelable
{

    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("descendants")
    @Expose
    private Integer descendants;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("kids")
    @Expose
    private ArrayList<Integer> kids = null;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    public final static Creator<Stories> CREATOR = new Creator<Stories>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Stories createFromParcel(Parcel in) {
            return new Stories(in);
        }

        public Stories[] newArray(int size) {
            return (new Stories[size]);
        }

    }
            ;

    protected Stories(Parcel in) {
        this.by = ((String) in.readValue((String.class.getClassLoader())));
        this.descendants = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.kids, (Integer.class.getClassLoader()));
        this.score = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.time = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Stories() {
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public Integer getDescendants() {
        return descendants;
    }

    public void setDescendants(Integer descendants) {
        this.descendants = descendants;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(by);
        dest.writeValue(descendants);
        dest.writeValue(id);
        dest.writeList(kids);
        dest.writeValue(score);
        dest.writeValue(time);
        dest.writeValue(title);
        dest.writeValue(type);
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }

}

