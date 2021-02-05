import { ENDPOINT_TASKS } from '../../../utils/Api'
import { Link } from 'react-router-dom'

const Task = ({ id, completed, title, tasks, setTasks }) => {
  // no actualiza la tarea
  const handleOnChange = (e) => {
    const updatedTask = {
      id,
      title,
      completed: e.target.checked,
    }

    const init = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updatedTask),
    }

    fetch(`${ENDPOINT_TASKS}${id}`, init)
      .then((response) => {
        if (!response.ok) throw new Error('Error updating task')
        setTasks([...tasks, updatedTask])
      })
      .catch((e) => console.log(e))
  }

  const handleDelete = () => {
    const init = {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
    }

    fetch(`${ENDPOINT_TASKS}/${id}`, init).then((response) => {
      if (!response.ok) throw new Error('Error deleting task')
      setTasks(tasks.filter((task) => task.id !== id))
    })
  }

  return (
    <>
      <div>
        <label>
          <input
            type='checkbox'
            checked={completed}
            onChange={(e) => handleOnChange(e)}
          />
          {title}
        </label>
      </div>
      <div>
        <Link to={`/tasks/${id}`}>
          <i class='fas fa-edit edit-i'></i>
        </Link>
        <i class='fas fa-trash-alt alert-i' onClick={handleDelete}></i>
      </div>
    </>
  )
}

export default Task
