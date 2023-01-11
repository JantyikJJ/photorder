package com.nyomorultak.spring.web;

public class user {
    public int id;
    public int userId;
    public String fileLocation;
    public int status;
    public int printWidth;
    public int printHeight;


    public user() {
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public int getStatus() {
        return status;
    }

    public int getPrintWidth() {
        return printWidth;
    }

    public int getPrintHeight() {
        return printHeight;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", userId=" + userId +
                ", fileLocation='" + fileLocation + '\'' +
                ", status=" + status +
                ", printWidth=" + printWidth +
                ", printHeight=" + printHeight +
                '}';
    }
}
