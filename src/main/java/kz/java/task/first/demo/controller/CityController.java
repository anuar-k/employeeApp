package kz.java.task.first.demo.controller;

import kz.java.task.first.demo.model.City;
import kz.java.task.first.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/countryName/{name}")
    public ResponseEntity<List<City>> getByName(@PathVariable String name){
        return ResponseEntity.ok(cityService.getByCountryName(name));
    }
}
