package kz.java.task.first.demo.controller;

import kz.java.task.first.demo.model.Country;
import kz.java.task.first.demo.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<List<Country>> findAll(){
        return ResponseEntity.ok(countryService.findAll());
    }
}
