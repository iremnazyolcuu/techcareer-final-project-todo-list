package com.iremnazyolcu.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data

// ENTITY
@Entity
// Hibernate will create this table in a database with the following entities :
@Table(name = "todos")
public class ToDoEntity implements Serializable {

    // Serialization
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long id;

    // TITLE
    @Column(nullable = false)
    private String title;

    // DESCRIPTION
    @Column(nullable = false)
    private String description;

    // COMPLETED
    private boolean completed;

}
