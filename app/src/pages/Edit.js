import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { ENDPOINT_TASKS } from '../utils/Api'
import Title from '../components/title/Title'
import Button from '../components/button/Button'
import '../components/tasks/edit-task/EditTask.css'

const Edit = () => {
  const { id } = useParams()
  const [task, setTask] = useState(null)

  useEffect(() => {
    fetch(`${ENDPOINT_TASKS}/${id}`, { method: 'GET' })
      .then((response) => response.json())
      .then((object) => {
        setTask(object)
        console.log(task)
      })
  }, [])

  const handleChangeTitle = (e) => setTask({ title: e.target.value })

  const handleSubmit = (e) => {
    e.preventDefault()
    if (!task.title) return alert('Complete the field!')

    const init = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title: task.title }),
    }

    fetch(`${ENDPOINT_TASKS}/${id}`, init).then((response) => {
      if (!response.ok) throw new Error('Error creating task')
      e.target.reset()
    })
  }

  return (
    <>
      {task && (
        <>
          <Title text={`Editing task "${task.title}"`} />
          <form
            className='edit-task-container'
            autoComplete='off'
            onSubmit={(e) => handleSubmit(e)}
          >
            <input
              type='text'
              name='title'
              value={task.title}
              className='input-submit'
              onChange={(e) => handleChangeTitle(e)}
            />
            <div className='edit-task-container__cta'>
              <Button type='submit' text='Save' />
              <Button type='submit' text='Cancel' />
            </div>
          </form>
        </>
      )}
    </>
  )
}

export default Edit
