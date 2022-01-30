import { lazy, Suspense } from "react";
import { Route, Routes } from "react-router";
import './App.css';

const  AdminLayout = lazy(()=>import("./components/containers/AdminLayout"));
const  UsersListPage = lazy(()=>import( "./components/admin/users/List"));

const DefaultLayout = lazy(()=>import("./components/containers/DefaultLayout"));
const HomePage = lazy(()=>import("./components/Home"));

function App() {
  return (
    <>
      <Routes>
        <Route
          path="/"
          element={
            <Suspense fallback={<div>Loading ...</div>}>
              <DefaultLayout />
            </Suspense>
          }
        >
          <Route
            index
            element={
              <Suspense fallback={<div>Loading ...</div>}>
                <HomePage />
              </Suspense>
            }
          />
        </Route>

        <Route
          path="/admin"
          element={
            <Suspense fallback={<div>Loading ...</div>}>
              <AdminLayout />
            </Suspense>
          }
        >
          <Route index element={
             <Suspense fallback={<div>Loading ...</div>}>
               <UsersListPage />
             </Suspense>
          } />
        </Route>
      </Routes>
    </>
  );
}

export default App;
