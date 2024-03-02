package kz.java.task.first.demo.service;

import kz.java.task.first.demo.model.City;
import kz.java.task.first.demo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public List<City> getByCountryName(String name) {
        return repository.findByCountryName(name).get();
    }
}
