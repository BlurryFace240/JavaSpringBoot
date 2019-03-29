package com.endava.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="intern")
public class Intern {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name",unique = false,nullable = false)
    private String name;

    @Column(name="age",unique = false,nullable = false)
    private int age;
    
    @Column(name = "stream",unique = false,nullable = false)
    @Enumerated(EnumType.STRING)
    private InternStreams stream;

    public Intern() {}

    public Intern(int id,String name, int age, InternStreams stream) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.stream = stream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public InternStreams getStream() {
        return stream;
    }

    public void setStream(InternStreams stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", stream=" + stream +
                '}';
    }
}
