package kz.java.task.first.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firsName;

    private String lastName;

    private String middleName;

    private String number;

    private String country;

    private String city;
}