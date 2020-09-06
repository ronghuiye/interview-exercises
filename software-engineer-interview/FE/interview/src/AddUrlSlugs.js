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

  const handleUrlChange = (e) => {
    setUrl(e.target.value)
  }

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value)
  }

  const handleOnClick = () => {
    props.submit(url, description)
  }

  return (
    <React.Fragment>
      <TextField id="url-text-field" label="Url" value={url} onChange={handleUrlChange}/>
      <TextField id="description-text-field" label="Description" value={description} onChange={handleDescriptionChange}/>
      <Button id="submit-button" className={classes.button} variant="outlined" onClick={handleOnClick}>submit</Button>
    </React.Fragment>
  )

}

export default AddUrlSlugs