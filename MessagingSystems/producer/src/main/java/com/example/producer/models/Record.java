package com.example.producer.models;

import lombok.*;

//Below lombok annotations are not working as expected so declared manually.
@Getter
@Setter
@NoArgsConstructor
@Data
public class Record {
    // Getters and Setters
    private int id;
    private String data;

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

    public Record(int id, String data) {
        this.id=id;
        this.data=data;
    }
}

