import React, {useState} from "react"
import {TextField, Button} from '@material-ui/core'
import {makeStyles} from '@material-ui/core/styles'

const STYLES = {
  button: {
    margin: '20px'
  }
}

function AddUrlSlugs(props) {
  const classes = makeStyles(STYLES)()

  const [url, setUrl] = useState("")
  const [description, setDescription] = useState("")
  const [error, setError] = useState({
    url:'',
    description:''
  })

  const handleChange = (e) => {
    e.preventDefault()
    const {value,name} = e.target
    let err = error
    switch (name) {
      case 'url':
        setUrl(value)
        err.url = /^(ftp|http|https):\/\/[^ "]+$/.test(value) ? '' : 'Must be a valid url'
        break
      case 'description':
        setDescription(value)
        err.description = value.length < 5 ? 'Must be at least 5 characters long' : ''
        break
      default:
        break
    }

    setError(err)
  }

  const handleOnClick = () => {
    props.submit(url, description)
  }

  const isDisabled = () => {
    return error.url || error.description || url.length === 0 || description.length === 0
  }

  return (
    <React.Fragment>
      <TextField id="url-text-field" label="Url" name="url" value={url} helperText={error.url} onChange={handleChange}/>
      <TextField id="description-text-field" label="Description" name="description" value={description} helperText={error.description} onChange={handleChange}/>
      <Button id="submit-button" className={classes.button} variant="outlined" disabled={ isDisabled()} onClick={handleOnClick}>submit</Button>
    </React.Fragment>
  )

}

export default AddUrlSlugs