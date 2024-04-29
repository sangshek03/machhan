import React from "react";
// import BarcodeScanner from './component/barcode';
import BarcodeScanner2 from "./component/upload";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Barcode Scanner</h1>
      </header>
      <main>
        {/* <BarcodeScanner/>
         */}
        <BarcodeScanner2 />
      </main>
    </div>
  );
}

export default App;
