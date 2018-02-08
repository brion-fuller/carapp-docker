import React, { Component } from 'react';
import { connect } from 'react-redux';
import AppBar from 'material-ui/AppBar';
import { Route, Link } from 'react-router-dom';
import {Tabs, Tab} from 'material-ui/Tabs';
import Table from './components/Table';
import AddUser from './components/AddUser';
import './App.css';

class App extends Component {
  constructor(props){
    super(props);
  }
  render() {
    return (
      <div className="App">
        <AppBar
          title="React Example"
          iconClassNameRight="muidocs-icon-navigation-expand-more"
        />
        <Tabs>
          <Tab label="List Users" to="/" containerElement={<Link to="/">Add User</Link>}>
          </Tab>
          <Tab label="Add User" to="/add-user" containerElement={<Link to="/add-user">Add User</Link>}>
          </Tab>
        </Tabs>
        <Route exact path="/" component={Table}/>
        <Route exact path="/add-user" component={AddUser}/>
      </div>
    );
  }
}

export default connect(({router})=>{
  console.log(router);
  return {location:router.location};
})(App);
