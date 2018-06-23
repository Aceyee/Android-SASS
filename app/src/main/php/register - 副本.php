<?php
require "init.php";

$name = "SSS";
$user_name = "yezihan";
$user_pass = "yezihan123";
$user_email = "yezihan@gmail.com";

$sql_query = "insert into user(username, passwd, email) values('$user_name','$user_pass','$user_email');";

if(mysqli_query($con, $sql_query)){
    echo "<h3>Data Insertion Success</h3>";
}else{
    echo "Data insertion error".mysqli_error($con);
}
?>