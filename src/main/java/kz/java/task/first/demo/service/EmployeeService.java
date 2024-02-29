package kz.java.task.first.demo.service;

import kz.java.task.first.demo.model.Employee;
import kz.java.task.first.demo.model.dto.EmployeeCreateDto;
import kz.java.task.first.demo.model.dto.EmployeeSearchDto;
import kz.java.task.first.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee create(EmployeeCreateDto employee) {
        Employee newEmployee = Employee.builder()
                .country(employee.getCountry())
                .city(employee.getCity())
                .firsName(employee.getFirsName())
                .number(employee.getNumber())
                .middleName(employee.getMiddleName())
                .lastName(employee.getLastName())
                .build();
        return repository.save(newEmployee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Employee getById(Long id) {
        return repository.findById(id).get();
    }

    public Page<Employee> findByParams(Long id, String firsName, String lastName, String middleName, String number, String country, String city, Pageable paging) {
        return repository.findByParams(id, firsName, lastName, middleName, number, country, city, paging);
    }
}