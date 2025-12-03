package site.api.api_teste.reposities;

import org.springframework.data.jpa.repository.JpaRepository;

import site.api.api_teste.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {}
