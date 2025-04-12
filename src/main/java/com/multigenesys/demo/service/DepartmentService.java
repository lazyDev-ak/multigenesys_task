package com.multigenesys.demo.service;

import com.multigenesys.demo.dto.request.DepartmentRequestDto;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<?> saveDepartment(DepartmentRequestDto dto);
}
