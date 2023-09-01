import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

// FUNCTION
export default function ToDoList() {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [ToDoStateApi, setToDoStateApi] = useState([]);

  // USEEFFECT
  useEffect(() => {
    axios.get("http://localhost:4444/api/todos/list/all")
      .then((response) => {
        console.log(response.data);
        setToDoStateApi(response.data);
      })
      .catch((err) => { console.error(err); });
  }, []);

  // GET ALL
  const getListToDo = (() => {
    axios.get("http://localhost:4444/api/todos/list/all")
      .then((response) => {
        console.log(response.data);
        setToDoStateApi(response.data);
      })
      .catch((err) => { console.error(err); });
  });

  // DELETE 
  const setDeleteToDo = ((id) => {
    if (window.confirm("Are you sure you want to delete?")) {
      axios.delete("http://localhost:4444/api/todos/delete/" + id)
        .then(() => {
          getListToDo();
        })
    } else {
      alert("Not deleted.");
    }
    navigate("/todos/list/all");
  });

  // UPDATE
  const setUpdateToDo = (data) => {
    let { id, title, description, completed } = data;
    localStorage.setItem("todo_update_id", id);
    localStorage.setItem("todo_update_title", title);
    localStorage.setItem("todo_update_description", description);
    localStorage.setItem("todo_update_completed", completed);
  }

  //VIEW
  const setViewToDo = (id) => {
    localStorage.setItem("todo_view_id", id);
  }

  //RETURN
  return (
    <React.Fragment>
      <h1 className="text-center display-3">Todo List</h1>
      <Link to="/todos/create" className="btn btn-primary">Add Todo</Link>
      <table className="table table-striped table-hover table-responsive">
        <thead>
          <tr>
            <th>ID</th>
            <th>TITLE</th>
            <th>DESCRIPTION</th>
            <th>COMPLETED</th>
            <th>UPDATE</th>
            <th>VIEW</th>
            <th>DELETE</th>
          </tr>
        </thead>
        <tbody>
          {
            ToDoStateApi.map((data) =>
              <tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.title}</td>
                <td>{data.description}</td>
                <td>{data.completed}</td>

                <td>
                  <Link to={`/todos/update/${data.id}`}>
                    <i onClick={() => setUpdateToDo(data)} class="fa-solid fa-pen-to-square text-primary"></i>
                  </Link>
                </td>

                <td>
                  <Link to={`/todos/view/${data.id}`}>
                    <i onClick={() => setViewToDo(data.id)} class="fa-solid fa-expand text-warning"></i>
                  </Link>
                </td>

                <td>
                  <Link to="/todos/delete">
                    <i onClick={() => setDeleteToDo(data.id)} class="fa-solid fa-trash text-danger"></i>
                  </Link>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </React.Fragment>
  )
}



