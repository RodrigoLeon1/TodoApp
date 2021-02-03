import './EditTask.css'

const EditTask = () => {
  //

  return (
    <form className='edit-task-container'>
      <input type='text' name='title' id='title' className='input-submit' />
      <div className='edit-task-container__cta'>
        <button type='submit' className='btn'>
          Save
        </button>
        <button className='btn btn-cancel'>Cancel</button>
      </div>
    </form>
  )
}

export default EditTask
