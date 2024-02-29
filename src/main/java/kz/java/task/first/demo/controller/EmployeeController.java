package kz.java.task.first.demo.controller;

import kz.java.task.first.demo.model.Employee;
import kz.java.task.first.demo.model.dto.EmployeeCreateDto;
import kz.java.task.first.demo.model.dto.EmployeeSearchDto;
import kz.java.task.first.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final String ID_COLUMN = "id";

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/id")
    public ResponseEntity<Employee> getById(@RequestBody Long id) {
        Employee employee = null;
        try {
            employee = employeeService.getById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/add")
    public ResponseEntity create(@RequestBody EmployeeCreateDto employee) {
        Employee newEmployee = null;
        try {
            newEmployee = employeeService.create(employee);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
        }
        return new ResponseEntity(newEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody EmployeeSearchDto searchValues) {

        Long id = searchValues.getId() != null ? searchValues.getId() : null;
        String firstName = searchValues.getFirsName() != null ? searchValues.getFirsName() : null;
        String lastName = searchValues.getLastName() != null ? searchValues.getLastName() : null;
        String middleName = searchValues.getMiddleName() != null ? searchValues.getMiddleName() : null;
        String number = searchValues.getNumber() != null ? searchValues.getNumber() : null;
        String country = searchValues.getCountry() != null ? searchValues.getCountry() : null;
        String city = searchValues.getCity() != null ? searchValues.getCity() : null;

        String sortColumn = searchValues.getSortColumn() != null ? searchValues.getSortColumn() : null;
        String sortDirection = searchValues.getSortDirection() != null ? searchValues.getSortDirection() : null;

        Integer pageNumber = searchValues.getPageNumber() != null ? searchValues.getPageNumber() : null;
        Integer pageSize = searchValues.getPageSize() != null ? searchValues.getPageSize() : null;

        if (id == null || id == 0) {
            return new ResponseEntity("missed param: id must be not null", HttpStatus.NOT_ACCEPTABLE);
        }
        Sort.Direction direction = sortDirection == null || sortDirection.trim().length() == 0 || sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, sortColumn, ID_COLUMN);

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        Page<Employee> result = employeeService.findByParams(id, firstName, lastName, middleName, number, country, city, pageRequest);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteById(@RequestBody Long id) {
        try {
            employeeService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}