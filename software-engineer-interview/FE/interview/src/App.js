import React from 'react';
import logo from './logo.svg';
import './App.css';
import AddUrlSlugs from './redux/container'

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <AddUrlSlugs />
        </header>

      </div>
    );
  }

}

export default App;
