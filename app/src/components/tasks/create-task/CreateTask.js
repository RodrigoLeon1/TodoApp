import './CreateTask.css'

const CreateTask = () => {
  //

  return (
    <form className='create-task-container'>
      <input
        type='text'
        name='title'
        id='title'
        placeholder='Insert title...'
        className='input-submit'
      />
      <button type='submit' className='btn'>
        Create task
      </button>
    </form>
  )
}

export default CreateTask
