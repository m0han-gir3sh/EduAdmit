import React from "react"
import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import Home from './Pages/HomePage/Home'
// import LandingPage from './Pages/LandingPage/LandingPage'
import Login from './Pages/Auth/Login'
import Signup from "./Pages/Auth/Signup";
// import Dashboard from "./Pages/Admin/Dashboard";

const LazyLandingPage = React.lazy(() =>
new Promise((resolve) =>
setTimeout(
  () => resolve(import('./Pages/LandingPage/LandingPage')),
  2000
  )
  )
  );
const LazyLandingPage2 = React.lazy(() =>
new Promise((resolve) =>
setTimeout(
  () => resolve(import('./Pages/Admin/Dashboard')),
  2000
  )
  )
  );

  const LazyLoadingIcon = () => (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh' }}>
      <img src="https://res.cloudinary.com/dadvxtk3n/image/upload/v1710780630/Eduadmit_v1-removebg-preview_wipzh6.png" alt="Lazy Loading Icon" />
    </div>
  );

function App() {

  return (
   <>
   <BrowserRouter>
   <Routes>
    {/* <Route exact path="/home" element={<LandingPage/>}></Route>  */}
    {/* <Route path="/home" element={<><React.Suspense fallback='Please Wait... Loading Page source'><LazyLandingPage/></React.Suspense></>} />  */}
    <Route path="/home" element={
    <>
      <React.Suspense fallback={<LazyLoadingIcon />}>
        <LazyLandingPage />
      </React.Suspense>
    </>
  } />
    <Route path="/admin" element={
    <React.Suspense fallback={<LazyLoadingIcon />}>
        <LazyLandingPage2 />
      </React.Suspense>
  } />
    <Route exact path="/" element={<Login/>}></Route>
    <Route exact path="/signup" element={<Signup/>}></Route>
    {/* <Route exact path="/admin" element={<Dashboard/>}></Route> */}
   </Routes>
   </BrowserRouter>
   </>
    )
}

export default App
