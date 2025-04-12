package com.multigenesys.demo.service;

import com.multigenesys.demo.dto.request.EmployeeRequestDto;
import com.multigenesys.demo.dto.request.FilterDto;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<?> getListOfEmployees(FilterDto dto);

    ResponseEntity<?> saveEmployee(EmployeeRequestDto dto);

    ResponseEntity<?> getEmployeeByDepartmentId(Long departmentId);
}
