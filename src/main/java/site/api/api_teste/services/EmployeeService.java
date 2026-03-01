package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import site.api.api_teste.dtos.EmployeeDTO;
import site.api.api_teste.entities.Employee;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.reposities.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<EmployeeDTO> findAll() {
        List<Employee> employeeEntityList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee : employeeEntityList) {
            employeeDTOList.add(toDTO(employee));
        }

        return employeeDTOList;
    }

    @Transactional
    public EmployeeDTO findById(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpsStatusCodes.NotFoundStatus(), "Employee not found"));

        return toDTO(employee);
    }

    @Transactional
    public EmployeeDTO saveEntity(EmployeeDTO dto) {
        Employee entity = toEntity(dto);
        Employee savedEntity = employeeRepository.save(entity);
        return toDTO(savedEntity);
    }

    @Transactional
    public EmployeeDTO changeEntity(EmployeeDTO dto) {
        Employee entity = toEntity(dto);
        Employee savedEntity = employeeRepository.save(entity);
        return toDTO(savedEntity);
    }

    @Transactional
    public void deleteEntity(String id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO toDTO(Employee entity) {
        return new EmployeeDTO(
                entity.getId(),
                entity.getName(),
                entity.getDepartment(),
                entity.getEmail(),
                entity.getPhone(),
                null);
    }

    private Employee toEntity(EmployeeDTO dto) {
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDepartment(dto.getDepartment());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
