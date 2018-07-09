<?php
require "init.php";

    $user_name = $_POST["login_name"];
    $user_pass = $_POST["login_pass"];

    $sql_query_username = "SELECT * from user WHERE username like '$user_name' and passwd like '$user_pass';";
    $result_username = mysqli_query($con, $sql_query_username);
    $response = array();
    if(mysqli_num_rows($result_username)>0){
        $row = mysqli_fetch_assoc($result_username);
        array_push($response, array("username"=>$row["username"], "passwd"=>$row["passwd"],"university"=>$row["university"], 
                "roll"=>$row["roll"],"email"=>$row["email"], "studentNO"=>$row["studentNO"]));
        echo json_encode(array("Login Success"=>$response));
    }else{
        echo "Login Fail. Please try again";
    }
?>