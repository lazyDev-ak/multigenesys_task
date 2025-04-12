package com.multigenesys.demo.service.impl;

import com.multigenesys.demo.dto.request.DepartmentRequestDto;
import com.multigenesys.demo.entity.Department;
import com.multigenesys.demo.repository.DepartmentRepository;
import com.multigenesys.demo.service.DepartmentService;
import com.multigenesys.demo.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;


    @Override
    public ResponseEntity<?> saveDepartment(DepartmentRequestDto dto) {
        ApiResponse apiResponse = new ApiResponse<>();
        try {
            Department department = new Department();
            department.setName(dto.getDepartmentName());
            repository.save(department);
            apiResponse.setStatusCode(HttpStatus.CREATED.value());
            apiResponse.setMessage("Department Created");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setMessage("Internal Server Error");
        }
        return ResponseEntity.ok(apiResponse);
    }
}
