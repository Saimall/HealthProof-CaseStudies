package com.example.consumer.models;

public class Record {


    private int id;
    private String data;

    public Record (){

    }

    public Record(int id, String data) {
        this.id=id;
        this.data=data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }


}
