package com.iremnazyolcu.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
public class ToDoDto implements Serializable {

    // Serialization
    public static final Long serialVersionUID = 1L;

    // ToDoDto attributes :

    // ID
    private Long id;

    // TITLE
    private String title;

    // DESCRIPTION
    private String description;

    // COMPLETED
    private boolean completed;

}
