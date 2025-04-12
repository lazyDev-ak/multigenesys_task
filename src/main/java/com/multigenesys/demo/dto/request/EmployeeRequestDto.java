package com.multigenesys.demo.dto.request;

import com.multigenesys.demo.entity.Department;
import com.multigenesys.demo.entity.Designation;
import com.multigenesys.demo.entity.Salary;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class EmployeeRequestDto {
    private Long id;

    private String name;

    private LocalDate joiningDate;

    private Department department;

    private Designation designation;

    private Double salary;

}
