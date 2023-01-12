package com.nyomorultak.spring.web;


import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private Boolean isStaff;
    private String password;

    public User() { }
    public User(int id, String name, String password, Boolean isStaff) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isStaff = isStaff;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + name + '\'' +
                ", isStaff=" + isStaff +
                ", password=" + password +
                '}';
    }
}
