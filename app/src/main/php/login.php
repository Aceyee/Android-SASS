<?php
require "init.php";

    #$user_name = "yezihan";
    #$user_pass = "yezihan123";
    $user_name = $_POST["login_name"];
    $user_pass = $_POST["login_pass"];

    //SELECT后面与数据库保持一致
    $sql_query_username = "SELECT username from user WHERE username like '$user_name' and passwd like '$user_pass';";
    $sql_query_roll = "SELECT roll from user WHERE username like '$user_name' and passwd like '$user_pass';";
    $result_username = mysqli_query($con, $sql_query_username);
    $result_roll = mysqli_query($con, $sql_query_roll);
    if(mysqli_num_rows($result_username)>0 && mysqli_num_rows($result_roll)>0){
        $row = mysqli_fetch_assoc($result_username);
        $name = $row["username"];
        $row = mysqli_fetch_assoc($result_roll);
        $roll = $row["roll"];
        echo "Login Success ".$name." (".$roll.")";
    }else{
        echo "Login Fail. Please try again";
    }
?>