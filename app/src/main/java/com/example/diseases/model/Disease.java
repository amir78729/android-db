package com.example.diseases.model;

public class Disease {
    private String name;
    private String descriptiom;

    public Disease(String name, String descriptiom) {
        this.name = name;
        this.descriptiom = descriptiom;
    }

    public Disease() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptiom() {
        return descriptiom;
    }

    public void setDescriptiom(String descriptiom) {
        this.descriptiom = descriptiom;
    }
}
