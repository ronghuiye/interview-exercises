import axios from 'axios'

class API {

  static submit(url, description) {
    const axiosInstance = axios.create()
    return axiosInstance({
      method: 'post',
      url: '/api/step2',
      headers: {
        'Cache-Control': 'no-cache',
        'Content-Type': 'application/json'
      },
      data: {
        'url': url,
        'description': description
      }
    })
      .then(response => response.data)
      .catch(error => console.log(error))
  }

  static redirect(content) {
    const axiosInstance = axios.create()
    return axiosInstance({
      method: 'post',
      url: '/api/step3',
      headers: {
        'Cache-Control': 'no-cache',
        'Content-Type': 'application/json'
      },
      data: {
        'slugs':content
      }

    })
      .then(response => response.data)
      .catch(error => console.log(error))
  }
}

export default API