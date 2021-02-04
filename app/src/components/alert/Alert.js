import './Alert.css'

const Alert = ({ type, info }) => (
  <div class={`alert alert-${type}`} role='alert'>
    {info}
  </div>
)

export default Alert
