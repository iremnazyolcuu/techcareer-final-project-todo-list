
// rcc (react component class)
import React, { Component } from 'react'

// ROUTER
import { Navigate, Route, Routes } from 'react-router-dom';

// I18N
import { withTranslation } from 'react-i18next';

// HEADER,FOOTER,MAIN
import Footer from './component/Footer';
import Header from './component/Header';
import Main from './component/Main';

// TODO
import ToDoCreate from './component/todos/ToDoCreate';
import ToDoList from './component/todos/ToDoList';
import ToDoView from './component/todos/ToDoView';
import ToDoUpdate from './component/todos/ToDoUpdate';


// CLASS COMPONENT
class TodoRouter extends Component {

    // Component görünen ismi
    static displayName = "Todo_Router";

    // Constructor
    constructor(props) {
        super(props);

        // STATE
        this.state = {}

        // BIND      
    } 

    // CDM

    // FUNCTION

    //RENDER
    render() {

        //RETURN
        return (
            <React.Fragment>
                <Header logo="fa-solid fa-warehouse" />

                <div className="container">
                    <Routes>
                        <Route path='/' element={<Main />} />

                        {/* Todo */}
                        <Route path="/todos/create" element={<ToDoCreate/>} />
                        <Route path="/todos/list/all" element={<ToDoList/>} />
                        <Route path="/todos/view/:id" element={<ToDoView/>} />
                        <Route path="/todos/update/:id" element={<ToDoUpdate/>} />
                        {/* bad request */}
                        <Route path="*" element={<Navigate to="/" />} />
                    </Routes>
                </div>

                <Footer copy="&copy; 2021 - 2023" />
            </React.Fragment>
        ) 
    } 
} 

// Higher Order Component
export default withTranslation()(TodoRouter);
