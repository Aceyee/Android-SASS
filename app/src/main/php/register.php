<?php
require "init.php";

$name = "SSS";
$user_name = $_POST["user_name"];
$user_pass = $_POST["user_pass"];
$user_roll = $_POST["user_roll"];
$user_email = "yezihan@gmail.com";

$sql_query = "insert into user(username, passwd, email, roll) values('$user_name','$user_pass','$user_email','$user_roll');";

if(mysqli_query($con, $sql_query)){
    echo "<h3>Data Insertion Success</h3>";
}else{
    echo "Data insertion error".mysqli_error($con);
}
?>