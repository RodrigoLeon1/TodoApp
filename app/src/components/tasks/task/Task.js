const Task = ({ id, isCompleted, title }) => (
  <>
    <div>
      <label>
        <input type='checkbox' />
        {title}
      </label>
    </div>
    <div>
      <i class='fas fa-edit'></i>
      <i class='fas fa-trash-alt'></i>
    </div>
  </>
)

export default Task
