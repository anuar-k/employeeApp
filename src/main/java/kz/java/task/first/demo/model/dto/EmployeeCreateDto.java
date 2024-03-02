package kz.java.task.first.demo.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeCreateDto {

    @NotEmpty(message = "firstName must not empty")
    @NotNull(message = "firstName must not null")
    private String firstName;

    @NotEmpty(message = "lastName must not empty")
    @NotNull(message = "lastName must not null")
    private String lastName;

    private String middleName;

    @NotEmpty(message = "Email address is required.")
    @Email(message="Email not valid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotEmpty
    @Pattern(regexp = "^\\d{10}$")
    private String number;

    private String country;

    private String city;
}