package nyomorultak.photorder.user;
import jakarta.persistence.*;

@Entity
@Table
public class PhotorderUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    public int id;
    public String name;
    public String password;
    public boolean isStaff;

    public PhotorderUser() {
    }

    public PhotorderUser(int id, String name, String password, Boolean isStaff) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isStaff = isStaff;
    }

    public PhotorderUser(String name, String password, Boolean isStaff) {
        this.name = name;
        this.password = password;
        this.isStaff = isStaff;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + password + '\'' +
                ", isStaff=" + isStaff +
                '}';
    }
}
