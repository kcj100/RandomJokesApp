package com.kcj.randomjokes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// POJO - Plain old Java object
@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {
    private String id;
    private String value;

    public Joke() {
    }

    public Joke(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
