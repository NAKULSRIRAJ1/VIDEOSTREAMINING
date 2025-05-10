import { useState } from "react";
import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Watch from "./pages/Watch";

import Dashboard from "./pages/Dashboard";

function App() {
  const [language, setLanguage] = useState("English");

  return (
    <>
      <Navbar setLanguage={setLanguage} />
      <Routes>
        <Route path="/" element={<Home language={language} />} />
        <Route path="/watch/:id" element={<Watch />} />
      
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </>
  );
}

export default App;
