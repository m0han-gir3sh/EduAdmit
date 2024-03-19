import React from "react"
import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import Home from './Pages/HomePage/Home'
import LandingPage from './Pages/LandingPage/LandingPage'
import Login from './Pages/Auth/Login'
import Signup from "./Pages/Auth/Signup";
import Dashboard from "./Pages/Admin/Dashboard";

function App() {

  return (
   <>
   <BrowserRouter>
   <Routes>
    <Route exact path="/home" element={<LandingPage/>}></Route>
    <Route exact path="/" element={<Login/>}></Route>
    <Route exact path="/signup" element={<Signup/>}></Route>
    <Route exact path="/admin" element={<Dashboard/>}></Route>
   </Routes>
   </BrowserRouter>
   </>
    )
}

export default App
