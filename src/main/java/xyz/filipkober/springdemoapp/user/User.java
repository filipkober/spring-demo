package xyz.filipkober.springdemoapp.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")

public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    @Transient
    private int age;
    public User() {
    }

    public User(long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
    public  void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
