import useFetch from '../hooks/useFetch'
import Title from '../components/title/Title'
import TaskList from '../components/tasks/task-list/TaskList'
import CreateTask from '../components/tasks/create-task/CreateTask'
import { ENDPOINT_TASKS } from '../utils/Api'

const Home = () => {
  const { data: tasks, setData } = useFetch(ENDPOINT_TASKS, 'GET')

  return (
    <>
      <Title text='To-Do List' />
      {tasks.length > 0 ? (
        <TaskList tasks={tasks} setTasks={setData} />
      ) : (
        <h4>Empty list!</h4>
      )}
      <CreateTask tasks={tasks} setTasks={setData} />
    </>
  )
}
export default Home
