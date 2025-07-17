package com.employee.employeedb.controller;

import com.employee.employeedb.dto.EmployeeDto;
import com.employee.employeedb.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private final EmployeeService employeeService;

    @PostMapping("/post")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeDto);
        logger.info("Received Employee JSON:\n{}", prettyJson);

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        logger.info("Employee created with ID: {}", savedEmployee.getId());

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        logger.info("Fetching employee with ID: {}", employeeId);
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        logger.info("Fetched employee: {}", employeeDto);
        return ResponseEntity.ok(employeeDto);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        logger.info("Fetching all employees");
        List<EmployeeDto> employees = employeeService.getALLEmployees();
        logger.info("Total employees fetched: {}", employees.size());
        return ResponseEntity.ok(employees);
    }


    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee) {

        logger.info("Updating employee ID: {} with data: {}", employeeId, updatedEmployee);
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        logger.info("Updated employee: {}", employeeDto);
        return ResponseEntity.ok(employeeDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        logger.info("Deleting employee with ID: {}", employeeId);
        employeeService.deleteEmployee(employeeId);
        logger.info("Employee with ID {} deleted successfully", employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
