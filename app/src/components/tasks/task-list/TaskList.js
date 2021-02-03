import Task from '../task/Task'
import './TaskList.css'

const TaskList = () => (
  <ul className='container-list'>
    <li className='container-list__item'>
      <Task title='Create fullstack application' />
    </li>
  </ul>
)

export default TaskList
