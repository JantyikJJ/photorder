package com.nyomorultak.spring.api;

public class ImageUploadRequest {
    public int userId;
    public String image;
    public int printWidth;
    public int printHeight;

    public ImageUploadRequest() { }
    public ImageUploadRequest(int userId, String image, int printWidth, int printHeight) {
        this.userId = userId;
        this.image = image;
        this.printWidth = printWidth;
        this.printHeight = printHeight;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrintWidth() {
        return printWidth;
    }

    public void setPrintWidth(int printWidth) {
        this.printWidth = printWidth;
    }

    public int getPrintHeight() {
        return printHeight;
    }

    public void setPrintHeight(int printHeight) {
        this.printHeight = printHeight;
    }
}