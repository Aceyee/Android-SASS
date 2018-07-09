<?php
    $server_name="localhost";
    $mysql_user="aceyee";
    $mysql_pass="Yzh1028#";
    $db_name="fcm";

    $con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);
    if(!$con){
        echo "connection error ".mysqli_connect_error();
    }else{
        echo "<h3>Database connection Success <\h3>";
    }
?>