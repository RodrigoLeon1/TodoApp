import Title from '../components/title/Title'
import TaskList from '../components/tasks/task-list/TaskList'
import CreateTask from '../components/tasks/create-task/CreateTask'

const Home = () => (
  <>
    <Title text='To-Do List' />
    <TaskList />
    <CreateTask />
  </>
)

export default Home
