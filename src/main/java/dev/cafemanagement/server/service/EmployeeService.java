package dev.cafemanagement.server.service;

import dev.cafemanagement.server.exception.employeeNotFoundException;
import dev.cafemanagement.server.model.Employee;
import dev.cafemanagement.server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
    public Optional<Employee> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findEmployeeByFirstNameAndLastName(firstName, lastName);
    }
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(employeeId);
        if(existingEmployee != null) {
            existingEmployee.setId(updatedEmployee.getId());
            existingEmployee.setRoles(updatedEmployee.getRoles());
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setContactNumber(updatedEmployee.getContactNumber());
            existingEmployee.setPosition(updatedEmployee.getPosition());
            existingEmployee.setBankAccountNumber(updatedEmployee.getBankAccountNumber());
            existingEmployee.setStartDate(updatedEmployee.getStartDate());
            existingEmployee.setWorkHours(updatedEmployee.getWorkHours());
            existingEmployee.setWagePerHour(updatedEmployee.getWagePerHour());
            return employeeRepository.save(existingEmployee);
        } else throw new employeeNotFoundException("Employee with id " + employeeId + " not found");
    }

    public List<Employee> getAllEmployees() { return employeeRepository.findAll();
    }
}
