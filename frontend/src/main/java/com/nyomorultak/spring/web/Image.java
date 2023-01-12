package com.nyomorultak.spring.web;

import java.io.Serializable;

public class Image implements Serializable {
    public final String[] STATUSES = new String[] { "Received", "In preparation", "In printing", "Done" };

    private int id;
    private int userId;
    private String fileLocation;
    private int status;
    private int printWidth;
    private int printHeight;

    public Image() { }
    public Image(int id, int userId, String fileLocation, int status, int printWidth, int printHeight) {
        this.id = id;
        this.userId = userId;
        this.fileLocation = fileLocation;
        this.status = status;
        this.printWidth = printWidth;
        this.printHeight = printHeight;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getFileLocation() {
        return "https://photorder-api.exmodify.com/" + fileLocation;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusString() {
        if (status < 0) return STATUSES[0];
        else if (status >= STATUSES.length) return STATUSES[STATUSES.length - 1];

        return STATUSES[status];
    }
    public void setStatusString(String statusString) {
        int status = STATUSES.length - 1;
        for (; status > 0; status--) {
            if (statusString.equalsIgnoreCase(STATUSES[status])) {
                break;
            }
        }
        this.status = status;
    }

    public int getPrintWidth() {
        return printWidth;
    }

    public int getPrintHeight() {
        return printHeight;
    }

    @Override
    public String toString() {
        return "photo{" +
                "id=" + id +
                ", userId=" + userId +
                ", fileLocation='" + fileLocation + '\'' +
                ", status=" + status +
                ", printWidth=" + printWidth +
                ", printHeight=" + printHeight +
                '}';
    }
}
