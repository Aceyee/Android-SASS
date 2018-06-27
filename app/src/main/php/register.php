<?php
require "init.php";

$name = "SSS";
$user_name = $_POST["user_name"];
$user_pass = $_POST["user_pass"];
$user_university = $_POST["user_university"];
$user_roll = $_POST["user_roll"];
$user_email = $_POST["user_email"];
$user_studentNO = $_POST["user_studentNO"];

$sql_query = "insert into user(username, passwd, university, roll, email, studentNO) values('$user_name','$user_pass','$user_university','$user_roll','$user_email','$user_studentNO');";

if(mysqli_query($con, $sql_query)){
    echo "<h3>Data Insertion Success</h3>";
}else{
    echo "Data insertion error".mysqli_error($con);
}
?>