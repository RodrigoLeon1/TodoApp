import Task from '../task/Task'
import './TaskList.css'

const TaskList = ({ tasks, setTasks }) => (
  <ul className='container-list'>
    {tasks.map((task) => (
      <li key={task.id} className='container-list__item'>
        <Task
          id={task.id}
          completed={task.completed}
          title={task.title}
          tasks={tasks}
          setTasks={setTasks}
        />
      </li>
    ))}
  </ul>
)

export default TaskList
