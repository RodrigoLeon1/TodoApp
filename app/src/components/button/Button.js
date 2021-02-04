import './Button.css'

const Button = ({ type, text }) => (
  <button type={type} className='btn'>
    {text}
  </button>
)

export default Button
