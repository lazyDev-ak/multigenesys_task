package com.multigenesys.demo.repository;

import com.multigenesys.demo.dto.response.EmployeeListResponseDto;
import com.multigenesys.demo.dto.response.EmployeeResponseDto;
import com.multigenesys.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select * from fn_get_employee_list(?1,?2,?3,?4,?5)",nativeQuery = true)
    List<EmployeeListResponseDto> getListOfEmployees(int page, int size, Long designationId, Double minSalary, Double maxSalary);

    List<EmployeeResponseDto> findAllEmployeeByDepartmentId(Long departmentId);

    @Query(value = "select  * from fn_get_employee_list_count(?1,?2,?3",nativeQuery = true)
    Long getListOfEmployeesCount(Long designationId, Double minSalary, Double maxSalary);
}
