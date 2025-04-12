package com.multigenesys.demo.utility;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class  ApiResponse<T> {

    private int statusCode;

    private T result;

    private String message;

    private Long count;
}
