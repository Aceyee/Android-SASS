<?php
    require "init.php";
    $fcm_token = $POST["fcm_token"];

    $sql = "INSERT INTO fcm_info values('".$fcm_token."');";
    mysqli_query($con, $sql);
    mysqli_close($con);
?>