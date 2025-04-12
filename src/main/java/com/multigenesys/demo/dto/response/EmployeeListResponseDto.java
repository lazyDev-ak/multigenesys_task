package com.multigenesys.demo.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;


@JsonPropertyOrder({"Sr No", "empId", "Employee Name", "Employee Designation", "Joining Date", "Department Name", "Salary"})
public interface EmployeeListResponseDto {

    @JsonProperty("empId")
    Long getEmpId();

    @JsonProperty("Sr No")
    Long getSrNo();

    @JsonProperty("Employee Name")
    String getName();

    @JsonProperty("Employee Designation")
    String getDesignation();

    @JsonProperty("Joining Date")
    Date getJoiningDate();

    @JsonProperty("Department Name")
    String getDepartmentName();

    @JsonProperty("Salary")
    String getSalary();
}
