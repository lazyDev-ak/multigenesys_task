package com.multigenesys.demo.service.impl;

import com.multigenesys.demo.dto.request.EmployeeRequestDto;
import com.multigenesys.demo.dto.request.FilterDto;
import com.multigenesys.demo.dto.response.EmployeeListResponseDto;
import com.multigenesys.demo.dto.response.EmployeeResponseDto;
import com.multigenesys.demo.entity.Employee;
import com.multigenesys.demo.entity.Salary;
import com.multigenesys.demo.repository.EmployeeRepository;
import com.multigenesys.demo.repository.SalaryRepository;
import com.multigenesys.demo.service.EmployeeService;
import com.multigenesys.demo.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public ResponseEntity<?> getListOfEmployees(FilterDto dto) {
        List<EmployeeListResponseDto> responseDto = repository.getListOfEmployees(dto.getPage(), dto.getSize(), dto.getDesignationId(), dto.getMinSalary(), dto.getMaxSalary());
        ApiResponse apiResponse = new ApiResponse<>();
        if (responseDto.isEmpty()) {
            apiResponse.setMessage("No Records Found");
            apiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());

        } else {
            apiResponse.setMessage("Employee List found");
            apiResponse.setResult(responseDto);
            apiResponse.setCount(repository.getListOfEmployeesCount(dto.getDesignationId(),dto.getMinSalary(),dto.getMaxSalary()));
            apiResponse.setStatusCode(HttpStatus.OK.value());

        }
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveEmployee(EmployeeRequestDto dto) {
        ApiResponse apiResponse = new ApiResponse<>();
        try {
            Employee employee = new Employee();
            employee.setName(dto.getName());
            employee.setDepartment(dto.getDepartment());
            employee.setDesignation(dto.getDesignation());

            Salary salary = salaryRepository.findByAmount(dto.getSalary()).orElse(new Salary());
            salary.setAmount(dto.getSalary());
            Salary salaryObj = salaryRepository.save(salary);
            employee.setSalary(salaryObj);

            repository.save(employee);
            apiResponse.setStatusCode(HttpStatus.CREATED.value());
            apiResponse.setMessage("Employee Created");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("Internal Server Error");
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<?> getEmployeeByDepartmentId(Long departmentId) {
        List<EmployeeResponseDto> employees = repository.findAllEmployeeByDepartmentId(departmentId);
        ApiResponse apiResponse = new ApiResponse<>();
        if (employees.isEmpty()) {
            apiResponse.setMessage("Records not found");
            apiResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
        } else {
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setResult(employees);
            apiResponse.setMessage("Records Found");
        }
        return ResponseEntity.ok(apiResponse);
    }
}
