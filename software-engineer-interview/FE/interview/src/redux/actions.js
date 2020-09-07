import API from './api'
export const submit = (url, description) => {

  return async (dispatch) => {
    try{
      const response = await API.submit(url, description)
      console.log(response)
      if(response && response.success){
        console.log(response)
        window.location=url
      }else{
        console.log('submit failed')
      }
      return response
    }catch(error){
      console.log(error)
      return error
    }
  }
}


export const redirect = (content) => {
console.log(content)
  return async (dispatch) => {
    try{
      const response = await API.redirect(content)
      if(response && response.success){
        console.log('redirect successfully')
      }else{
        console.log('redirect failed')
      }
      return response
    }catch(error){
      console.log(error)
      return error
    }
  }
}
