package kz.java.task.first.demo.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeSearchDto {

    private Long id;

    private String firsName;

    private String lastName;

    private String middleName;

    private String number;

    private String country;

    private String city;

    private Integer pageNumber;
    private Integer pageSize;

    private String sortColumn;
    private String sortDirection;
}