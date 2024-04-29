import React, { useState, useRef, useEffect } from "react";
import Quagga from "@ericblade/quagga2";

const BarcodeScanner = () => {
  const [barcode, setBarcode] = useState(null);
  const [capturedImage, setCapturedImage] = useState(null);
  const [detectionStatus, setDetectionStatus] = useState("Initializing...");
  const [cameraReady, setCameraReady] = useState(false);
  const videoRef = useRef(null);

  useEffect(() => {
    const startCamera = async () => {
      try {
        const stream = await navigator.mediaDevices.getUserMedia({
          video: {
            facingMode: "environment",
            width: { min: 640 },
            height: { min: 480 },
          },
        });
        const video = videoRef.current;
        video.srcObject = stream;

        // Wait for the 'loadedmetadata' event before playing the video
        video.addEventListener("loadedmetadata", () => {
          video
            .play()
            .catch((error) => console.error("Error playing video:", error));
        });

        setCameraReady(true);
        setDetectionStatus("Camera ready");
      } catch (error) {
        console.error("Error accessing the camera:", error);
        setDetectionStatus("Error accessing the camera");
      }
    };

    startCamera();

    return () => {
      const video = videoRef.current;
      if (video.srcObject) {
        const tracks = video.srcObject.getTracks();
        tracks.forEach((track) => track.stop());
      }
    };
  }, []);

  const captureImage = () => {
    const video = videoRef.current;
    const canvas = document.createElement("canvas");
    canvas.width = video.videoWidth;
    canvas.height = video.videoHeight;
    const ctx = canvas.getContext("2d");
    ctx.drawImage(video, 0, 0, canvas.width, canvas.height);
    const imageDataURL = canvas.toDataURL("image/jpeg");
    setCapturedImage(imageDataURL);
    scanBarcode(imageDataURL);
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
        readers: ["code_128_reader"],
      },
      locate: true,
      src: imageDataURL,
    };

    Quagga.decodeSingle(quaggaConf, (result) => {
      if (result && result.codeResult) {
        setBarcode(result.codeResult.code);
        setDetectionStatus("Barcode detected: " + result.codeResult.code);
      } else {
        setBarcode(null);
        setDetectionStatus("No barcode detected");
      }
    });
  };

  return (
    <div>
      <div style={{ position: "relative" }}>
        <video
          ref={videoRef}
          style={{ width: "100%", maxWidth: "640px" }}
          autoPlay
          playsInline
          muted
        ></video>
        {capturedImage && (
          <img
            src={capturedImage}
            alt="Captured"
            style={{
              position: "absolute",
              top: 0,
              left: 0,
              width: "100%",
              maxWidth: "640px",
              zIndex: 1,
            }}
          />
        )}
      </div>
      <button onClick={captureImage} disabled={!cameraReady || capturedImage}>
        {capturedImage ? "Image Captured" : "Capture"}
      </button>
      <p>{detectionStatus}</p>
      {barcode && <p>Detected barcode: {barcode}</p>}
    </div>
  );
};

export default BarcodeScanner;
