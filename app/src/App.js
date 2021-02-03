import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'

import Home from './pages/Home'
import Edit from './pages/Edit'

const App = () => (
  <Router>
    <div className='container'>
      <Switch>
        <Route exact path='/'>
          <Home />
        </Route>
        <Route path='/tasks/:id'>
          <Edit />
        </Route>
        <Route path='*'>404 page</Route>
      </Switch>
    </div>
  </Router>
)

export default App
