<?php
    $db_name="userlogin";
    $mysql_user="root";
    $mysql_pass="Yzh1028#";
    $server_name="localhost";

    $con = mysql_connect($server_name, $mysql_user, $mysql_pass, $db_name);
    if(!$con){
        echo "connection error".mysql_connect_error();
    }else{
        echo "<h3>Database connection Success<\h3>";
    }
?>