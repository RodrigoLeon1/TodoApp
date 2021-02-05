import './Button.css'

const Button = ({ type, text, classCss = '' }) => (
  <button type={type} className={`btn ${classCss}`}>
    {text}
  </button>
)

export default Button
