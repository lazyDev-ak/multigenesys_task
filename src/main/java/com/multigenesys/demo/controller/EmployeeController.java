package com.multigenesys.demo.controller;

import com.multigenesys.demo.dto.request.EmployeeRequestDto;
import com.multigenesys.demo.dto.request.FilterDto;
import com.multigenesys.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/list")
    public ResponseEntity<?> getListOfEmployees(@RequestBody  FilterDto dto){
        return employeeService.getListOfEmployees(dto);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody  EmployeeRequestDto dto){
        return employeeService.saveEmployee(dto);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getEmployeeByDepartmentId(@PathVariable Long departmentId){
        return employeeService.getEmployeeByDepartmentId(departmentId);
    }

}
