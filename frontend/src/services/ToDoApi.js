// Axios
import axios from "axios";

// Persist URL
const TODO_URL = "/api/todos"

class ToDoApi {

    // CREATE
    // http://localhost:4444/api/todos/create
    // @PostMapping("/create")
    createTodo(todoDto) {
        return axios.post(`${TODO_URL}/create`, todoDto);
    }

    // GET
    // http://localhost:4444/api/todos/list/1
    // @GetMapping("/list/{id}")
    getTodo(id) {
        return axios.get(`${TODO_URL}/list/${id}`);
    }

    // GET ALL
    // http://localhost:4444/api/todos/list/all
    // @GetMapping("/list/all")
    getAllTodos() {
        return axios.get(`${TODO_URL}/list/all`);
    }

    // UPDATE
    // http://localhost:4444/api/todos/update/1
    // @PutMapping("/update/{id}")
    updateTodo(todoDto, id) {
        return axios.put(todoDto, `${TODO_URL}/update/${id}`);
    }

    // DELETE
    // http://localhost:4444/api/todos/delete/1
    // @DeleteMapping("/delete/{id}")
    deleteTodo(id) {
        return axios.delete(`${TODO_URL}/delete/${id}`);
    }
    
}

export default new ToDoApi();
