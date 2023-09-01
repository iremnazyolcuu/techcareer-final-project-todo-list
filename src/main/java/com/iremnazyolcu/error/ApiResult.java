package com.iremnazyolcu.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

// LOMBOK
@Data

// JSON
// Eğer bu fieldlarda null değer varsa backend kısmına gitmesin anlamında
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResult {

    private int status;
    private String message;
    private String error;
    private String path;
    private Map<String, String> validationErrors;
    private Date systemDate;

    // Parametresiz Constructor
    public ApiResult() {
    }

    // Parametreli Constructor
    public ApiResult(String path, String message, int status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }
}