package com.iremnazyolcu.business.services.impl;

import com.iremnazyolcu.business.dto.ToDoDto;
import com.iremnazyolcu.business.services.ToDoService;
import com.iremnazyolcu.data.entity.ToDoEntity;
import com.iremnazyolcu.data.repository.ToDoRepository;
import com.iremnazyolcu.exception.TodoNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
// Constructor based dependency injection
@AllArgsConstructor
// ToDoServiceImpl class implements the ToDoService interface and its methods.
public class ToDoServiceImpl implements ToDoService {

    // Injection
    // This ToDoServiceImpl requires ToDoRepository as a dependency.
    private ToDoRepository todoRepository;
    private ModelMapper modelMapper;

    // CREATE
    @Override
    public ToDoDto createTodo(ToDoDto todoDto) {

        // Model Mapper Library is one of the mapping library that we can use to automatically convert
        // DTO into Entity and Entity into DTO.
        ToDoEntity todo = modelMapper.map(todoDto, ToDoEntity.class);
        ToDoEntity savedTodo = todoRepository.save(todo);
        ToDoDto savedTodoDto = modelMapper.map(savedTodo, ToDoDto.class);
        return savedTodoDto;
    }

    // GET
    @Override
    public ToDoDto getTodo(Long id) {

        // retrieve the ToDo entity object from the database :
        ToDoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id:" + id));

        // getTodo() method return type is ToDoDto
        // so we should convert this ToDo entity object into ToDoDto :
        return modelMapper.map(todo, ToDoDto.class);

    }

    // GET ALL
    @Override
    public List<ToDoDto> getAllTodos() {
        List<ToDoEntity> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, ToDoDto.class))
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public ToDoDto updateTodo(ToDoDto todoDto, Long id) {

        ToDoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id : " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        ToDoEntity updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, ToDoDto.class);
    }

    // DELETE
    @Override
    public void deleteTodo(Long id) {

        ToDoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id : " + id));

        todoRepository.deleteById(id);
    }

    // COMPLETE
    @Override
    public ToDoDto completeTodo(Long id) {

        ToDoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.TRUE);

        ToDoEntity updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, ToDoDto.class);
    }

    // INCOMPLETE
    @Override
    public ToDoDto inCompleteTodo(Long id) {

        ToDoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.FALSE);

        ToDoEntity updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, ToDoDto.class);
    }

    // DELETE ALL
    @Override
    public String deleteAllTodos() {
        todoRepository.deleteAll();
        return "Total number of deleted tasks: " + getAllTodos().size();
    }

    // GET COMPLETED
    @Override
    public List<ToDoDto> getCompletedTodo(boolean completed) {
        List<ToDoEntity> completedTodos = todoRepository.findAllByCompleted(completed);

        return completedTodos.stream()
                .map(entity -> modelMapper.map(entity, ToDoDto.class))
                .collect(Collectors.toList());

    }

    // DELETE COMPLETED
    @Override
    public void deleteCompletedTodo() {
        List<ToDoEntity> completedTodos = todoRepository.findAllByCompleted(true);
        for (ToDoEntity completedTodo : completedTodos) {
            todoRepository.delete(completedTodo);

        }

    }

}
