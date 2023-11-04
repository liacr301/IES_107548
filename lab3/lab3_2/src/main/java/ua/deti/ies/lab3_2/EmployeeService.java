package ua.deti.ies.lab3_2;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee getEmployeesByEmail(String email);

    void deleteEmployee(Long employeeId);
}