package com.multigenesys.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {

    private int page=0;
    private int size=10;
    private Double minSalary;
    private Double maxSalary;
    private Long designationId;
//    private Long departmentId;

}
