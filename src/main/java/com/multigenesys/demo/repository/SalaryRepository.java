package com.multigenesys.demo.repository;

import com.multigenesys.demo.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary,Long> {
    Optional<Salary> findByAmount(Double salary);
}
