package com.endava.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Intern {
    private int id;
    private String name;
    private int age;
    private InternStreams stream;

    public Intern(String name, int age, InternStreams stream) {
        this.name = name;
        this.age = age;
        this.stream = stream;
    }
}
