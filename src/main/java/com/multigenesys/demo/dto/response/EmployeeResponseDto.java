package com.multigenesys.demo.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public interface EmployeeResponseDto {
    @JsonProperty("id")
    Long getId();

    @JsonProperty("name")
    String getName();
}
