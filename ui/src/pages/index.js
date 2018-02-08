import React from 'react';
import { Route } from 'react-router-dom';

import Table from '../components/Table';
import AddUser from '../components/AddUser';

export default () => (
    <div>
        <Route exact path="/" component={Table}/>
        <Route path="/add-user" component={AddUser}/>
    </div>
)
