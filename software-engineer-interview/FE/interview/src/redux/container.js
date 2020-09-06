import {connect} from 'react-redux'
import AddUrlSlugs from '../AddUrlSlugs';
import { submit, redirect } from "./actions";

function mapStateToProps(state) {
  return {

  }
}

const mapDispatchToProps = {
  submit, redirect
}

export default connect(mapStateToProps, mapDispatchToProps)(AddUrlSlugs)