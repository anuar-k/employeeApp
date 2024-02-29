package kz.java.task.first.demo.repository;

import kz.java.task.first.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE " +
            "(:firsName is null or :firsName='' or lower(:firsName) like lower(concat('%', :firsName, '%'))) and" +
            "(:lastName is null or :lastName='' or lower(:lastName) like lower(concat('%', :lastName, '%'))) and" +
            "(:middleName is null or :middleName='' or lower(:middleName) like lower(concat('%', :middleName, '%'))) and" +
            "(:city is null or :city='' or lower(:city) like lower(concat('%', :city, '%'))) and" +
            "(:country is null or :country='' or lower(:country) like lower(concat('%', :country, '%'))) and" +
            "(:number is null or e.number=:number) and " +
            "(e.id =:id)"
    )
    Page<Employee> findByParams(@Param("id") Long id,
                                @Param("firsName") String firsName,
                                @Param("lastName") String lastName,
                                @Param("middleName") String middleName,
                                @Param("number") String number,
                                @Param("country") String country,
                                @Param("city") String city,
                                Pageable pageable
    );
}