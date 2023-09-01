package com.iremnazyolcu.business.services;

import com.iremnazyolcu.business.dto.ToDoDto;

import java.util.List;

public interface ToDoService {

    // we have created addTodo method in a ToDoService interface:

    // CREATE
    ToDoDto createTodo(ToDoDto todoDto);

    // GET
    ToDoDto getTodo(Long id);

    // GET ALL
    List<ToDoDto> getAllTodos();

    // UPDATE
    ToDoDto updateTodo(ToDoDto todoDto, Long id);

    // DELETE
    void deleteTodo(Long id);

    // COMPLETE
    ToDoDto completeTodo(Long id);

    // INCOMPLETE
    ToDoDto inCompleteTodo(Long id);

    // DELETE ALL
    String deleteAllTodos();

    // GET COMPLETED
    List<ToDoDto> getCompletedTodo(boolean completed);

    // DELETE COMPLETED
    void deleteCompletedTodo();

}
