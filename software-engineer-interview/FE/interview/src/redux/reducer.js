import { actionTypes } from './constants'

const initialState = {
}

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.ADD:
      return {
        ...state,
        answer: action.data
      }
    default:
      return state
  }
}

export default reducer