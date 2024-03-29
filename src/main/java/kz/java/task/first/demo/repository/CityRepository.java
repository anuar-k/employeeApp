package kz.java.task.first.demo.repository;

import kz.java.task.first.demo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<List<City>> findByCountryName(String name);
}