<?php
require "init2.php";

$name = "SSS";
$university = $_POST["university"];
$course = $_POST["course"];
$professor = $_POST["professor"];

$sql_query = "insert into session(university, course, professor) values('$university','$course','$professor');";

if(mysqli_query($con, $sql_query)){
    echo "<h3>Data Insertion Success</h3>";
}else{
    echo "Data insertion error".mysqli_error($con);
}
?>