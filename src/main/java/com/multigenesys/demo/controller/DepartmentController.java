package com.multigenesys.demo.controller;

import com.multigenesys.demo.dto.request.DepartmentRequestDto;
import com.multigenesys.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveDepartment(DepartmentRequestDto dto){
        return departmentService.saveDepartment(dto);
    }
}
