import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { Link } from 'react-router-dom'
import { ENDPOINT_TASKS } from '../utils/Api'
import Alert from '../components/alert/Alert'
import Title from '../components/title/Title'
import Button from '../components/button/Button'
import '../components/tasks/edit-task/EditTask.css'

const Edit = () => {
  const { id } = useParams()
  const [task, setTask] = useState(null)
  const [error, setError] = useState(false)
  const [success, setSuccess] = useState(null)

  useEffect(() => {
    fetch(`${ENDPOINT_TASKS}${id}`, { method: 'GET' })
      .then((response) => response.json())
      .then((object) => {
        setTask(object)
      })
  }, [])

  const handleChangeTitle = (e) => setTask({ ...task, title: e.target.value })

  const handleSubmit = (e) => {
    e.preventDefault()
    if (!task.title) return alert('Complete the field!')

    const init = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(task),
    }

    fetch(`${ENDPOINT_TASKS}${id}`, init)
      .then((response) => {
        if (!response.ok) throw new Error('Error creating task')
        setSuccess(true)
      })
      .catch((e) => {
        console.log('Error', e)
        setError(true)
      })
  }

  return (
    <>
      {error && <Alert type='danger' info='Error updating task.' />}
      {success && <Alert type='success' info='Task updated.' />}
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
              <Link to='/'>
                <Button type='button' text='Cancel' classCss='btn-cancel' />
              </Link>
            </div>
          </form>
        </>
      )}
    </>
  )
}

export default Edit
