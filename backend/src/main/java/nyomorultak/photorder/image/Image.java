package nyomorultak.photorder.image;

import jakarta.persistence.*;

@Entity
@Table
public class Image {
    @Id
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_sequence"
    )
    public int id;
    public int userId;
    public String fileLocation;
    public int status;
    public int printWidth;
    public int printHeight;

    public Image() { }
    public Image(int id, int userId, String fileLocation, int status, int printWidth, int printHeight) {
        this.id = id;
        this.userId = userId;
        this.fileLocation = fileLocation;
        this.status = status;
        this.printWidth = printWidth;
        this.printHeight = printHeight;
    }
    public Image(int userId, String fileLocation, int status, int printWidth, int printHeight) {
        this.userId = userId;
        this.fileLocation = fileLocation;
        this.status = status;
        this.printWidth = printWidth;
        this.printHeight = printHeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", userId=" + userId +
                ", fileLocation='" + fileLocation + '\'' +
                ", status=" + status +
                ", printWidth=" + printWidth +
                ", printHeight=" + printHeight +
                '}';
    }
}
