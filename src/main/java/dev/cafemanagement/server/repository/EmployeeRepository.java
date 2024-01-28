package dev.cafemanagement.server.repository;

import dev.cafemanagement.server.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
}
