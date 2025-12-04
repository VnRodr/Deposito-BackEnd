package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import site.api.api_teste.entities.Employee;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.reposities.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        List<Employee> EmployeeEntityList = employeeRepository.findAll();

        return new ArrayList<>(EmployeeEntityList);
    }

    public Employee findById(String id)
    {
        return employeeRepository.findById(id)   
                .orElseThrow(() -> new ResponseStatusException(HttpsStatusCodes.NotFoundStatus() 
                , "Employee not found"));
    }

    public void saveEntity(Employee entity)
    {
        employeeRepository.save(entity);
    }

    public void changeEntity (Employee newEntity)
    {
        employeeRepository.save(newEntity);
    }

    public void deleteEntity (String id)
    {
        employeeRepository.deleteById(id);
    }
}
