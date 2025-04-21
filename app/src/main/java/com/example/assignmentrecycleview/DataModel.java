package com.example.assignmentrecycleview;

public class DataModel {
    private String name;
    private String version;
    private int image;
    private int _id;

    public DataModel(){

    }
    public DataModel(String name, String version, int image, int _id) {
        this.name = name;
        this.version = version;
        this.image = image;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int get_id() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}