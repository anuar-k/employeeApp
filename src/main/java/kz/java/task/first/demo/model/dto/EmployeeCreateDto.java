package kz.java.task.first.demo.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeCreateDto {

    private String firsName;

    private String lastName;

    private String middleName;

    private String number;

    private String country;

    private String city;
}