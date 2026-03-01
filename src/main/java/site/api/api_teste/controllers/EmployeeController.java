package site.api.api_teste.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.api.api_teste.dtos.EmployeeDTO;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.services.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeController {
  @Autowired private EmployeeService employeeService;

  @GetMapping("/employees")
  public ResponseEntity<List<EmployeeDTO>> showAllemployees() {
    return ResponseEntity.ok(employeeService.findAll());
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<EmployeeDTO> findById(@PathVariable String id) {
    EmployeeDTO employee = employeeService.findById(id);
    return ResponseEntity.ok(employee);
  }

  @PostMapping("/create-employee")
  public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
    EmployeeDTO savedEmployee = employeeService.saveEntity(employee);
    URI location = URI.create("/api/create-employee" + savedEmployee.getId());
    return ResponseEntity.created(location).body(savedEmployee);
  }

  @PutMapping("/update-employee")
  public ResponseEntity<HttpsStatusCodes> atualizarEntidade(@RequestBody EmployeeDTO employee) {
    employeeService.changeEntity(employee);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/delete/employees/{id}")
  public ResponseEntity<HttpsStatusCodes> deletarEntidade(@PathVariable String id) {
    employeeService.deleteEntity(id);
    return ResponseEntity.ok().build();
  }
}
