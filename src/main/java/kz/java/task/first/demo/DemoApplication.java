package kz.java.task.first.demo;

import jakarta.annotation.PostConstruct;
import kz.java.task.first.demo.model.City;
import kz.java.task.first.demo.model.Country;
import kz.java.task.first.demo.repository.CityRepository;
import kz.java.task.first.demo.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(CountryRepository repository, CityRepository cityRepository) {
        return (args) -> {
            Country country1 = new Country(null, "Казахстан");
            Country country2 = new Country(null, "США");
            Country country3 = new Country(null, "Россия");
            Country country4 = new Country(null, "Китай");
            Country country5 = new Country(null, "Франция");
            Country country6 = new Country(null, "Бразилия");
            repository.save(country1);
            repository.save(country2);
            repository.save(country3);
            repository.save(country4);
            repository.save(country5);
            repository.save(country6);

            cityRepository.save(new City(null, "Астана", country1));
            cityRepository.save(new City(null, "Алматы", country1));
            cityRepository.save(new City(null, "Вашингтон", country2));
            cityRepository.save(new City(null, "Нью-Йор", country2));
            cityRepository.save(new City(null, "Москва", country3));
            cityRepository.save(new City(null, "Санкт-Петербург", country3));
            cityRepository.save(new City(null, "Пекин", country4));
            cityRepository.save(new City(null, "Шанхай", country4));
            cityRepository.save(new City(null, "Париж", country5));
            cityRepository.save(new City(null, "Тулуза", country5));
            cityRepository.save(new City(null, "Сан-Паулу", country6));
            cityRepository.save(new City(null, "Салвадор", country6));

        };
    }
}
