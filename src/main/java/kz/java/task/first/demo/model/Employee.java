package kz.java.task.first.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
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