import React, { useState } from "react";
import Quagga from "@ericblade/quagga2";

const BarcodeScanner2 = () => {
  const [barcode, setBarcode] = useState(null);
  const [detectionStatus, setDetectionStatus] = useState(
    "Waiting for barcode detection..."
  );

  const handleImageUpload = (event) => {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = () => {
        const imageDataURL = reader.result;
        setDetectionStatus("Scanning barcode...");
        scanBarcode(imageDataURL);
      };
      reader.readAsDataURL(file);
    }
  };

  const scanBarcode = (imageDataURL) => {
    const quaggaConf = {
      inputStream: {
        size: 800,
        singleChannel: false,
      },
      locator: {
        patchSize: "medium",
        halfSample: true,
      },
      numOfWorkers: 0,
      decoder: {
        readers: [
          "ean_reader",
          "upc_reader",
          "code_128_reader",
          "code_39_reader",
          "codabar_reader",
          "i2of5_reader",
          "2of5_reader",
          "code_93_reader",
        ],
      },
      locate: true,
      src: imageDataURL,
    };

    Quagga.decodeSingle(
      quaggaConf,
      (result) => {
        if (result && result.codeResult) {
          setBarcode(result.codeResult.code);
          setDetectionStatus("Barcode detected: " + result.codeResult.code);
        } else {
          setBarcode(null);
          setDetectionStatus("No barcode detected");
        }
      },
      (error) => {
        console.error("Error scanning barcode:", error);
        setDetectionStatus("Error scanning barcode");
      }
    );
  };

  return (
    <div>
      <input type="file" accept="image/*" onChange={handleImageUpload} />
      <p>{detectionStatus}</p>
      {barcode && <p>Detected barcode: {barcode}</p>}
    </div>
  );
};

export default BarcodeScanner2;
