import { useEffect, useState } from 'react'

const useFetch = (endpoint, method) => {
  const [data, setData] = useState([])
  const [error, setError] = useState(false)
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    fetch(endpoint, { method })
      .then((response) => response.json())
      .then((object) => setData(object))
      .catch((err) => {
        console.log(err)
        setError(true)
      })
      .finally(() => setIsLoading(false))
  }, [])

  return {
    data,
    setData,
    error,
    isLoading,
  }
}

export default useFetch
