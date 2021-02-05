import { useState } from 'react'
import { ENDPOINT_TASKS } from '../../../utils/Api'
import Button from '../../button/Button'
import './CreateTask.css'

const CreateTask = ({ tasks, setTasks }) => {
  const [title, setTitle] = useState('')
  const [isLoading, setIsLoading] = useState(false)

  const handleChangeTitle = (e) => setTitle(e.target.value)

  const handleSubmit = (e) => {
    e.preventDefault()
    if (!title) return alert('Complete the field!')
    setIsLoading(true)

    let newTask = {
      title,
      completed: false,
      folder: {
        id: 1, // Hardcoded for test
      },
    }

    const init = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newTask),
    }

    fetch(ENDPOINT_TASKS, init)
      .then((response) => {
        if (!response.ok) throw new Error('Error creating task')
        return response.json()
      })
      .then((object) => {
        newTask = { ...newTask, id: object.id }
        setTasks([newTask, ...tasks])
        setTitle('')
      })
      .catch((err) => console.log('Error...'))
      .finally(() => setIsLoading(false))
  }

  return (
    <form
      className='create-task-container'
      autoComplete='off'
      onSubmit={(e) => handleSubmit(e)}
    >
      <input
        type='text'
        name='title'
        value={title}
        placeholder='Insert task...'
        className='input-submit'
        onChange={(e) => handleChangeTitle(e)}
      />
      {isLoading ? (
        <Button type='submit' text='Saving...' />
      ) : (
        <Button type='submit' text='Create task' />
      )}
    </form>
  )
}

export default CreateTask
