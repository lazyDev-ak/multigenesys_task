package com.multigenesys.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate joiningDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @ManyToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

}