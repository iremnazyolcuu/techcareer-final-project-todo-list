import React, { Component } from 'react'
import { Link } from 'react-router-dom'

// Image
import moon from "../img/moon.jpg";

export default class Main extends Component {
  render() {
    return (
      <React.Fragment>
        <h1 className="display-3">Todo List</h1>
        <img src={moon} alt="" style={{width:"100%"}} />
         <Link className="btn btn-primary mt-5 mb-5" to="todos/list/all">Todo - List</Link>
      </React.Fragment>
    )
  }
}
