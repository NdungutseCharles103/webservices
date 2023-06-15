package rw.ac.rca.webservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    private int studId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    public Student() {

    }
}
