import * as React from "react";
import axios from "axios";
//import http from "../../../http_common";

const UsersListPage : React.FC =() => {

    React.useEffect(() => {
        console.log("begin");
        axios.get("http://localhost:8085/admin/roles").then((resp)=>console.log(resp));
    },[]);

    return (
        <>
            <h1>Список користувачів</h1>

        </>
    ); 
}
export default UsersListPage;