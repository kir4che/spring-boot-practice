package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
    @NotNull
    Integer id;
    @NotBlank
    String name;

    public void setId(Integer id) { this.id = id; }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
