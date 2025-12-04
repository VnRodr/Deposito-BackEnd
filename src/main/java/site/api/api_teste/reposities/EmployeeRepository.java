package site.api.api_teste.reposities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.api.api_teste.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {}
