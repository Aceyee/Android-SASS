<?php
require "init2.php";

$name = "SSS";
$university = $_POST["university"];
$course = $_POST["course"];
$professor = $_POST["professor"];

$sql_query_insertCourse = "insert into session(university, course, professor) values('$university','$course','$professor');";
$sql_query_getCourseID = "SELECT id from session WHERE university like '$university' and course like '$course' and professor like '$professor';";
if(mysqli_query($con, $sql_query_insertCourse)){
    $result = mysqli_query($con, $sql_query_getCourseID);
    $row = mysqli_fetch_array($result);
    $id = $row["id"];
    $sql_query_CreateSheet = "CREATE TABLE sheet".$id." (courseid INT PRIMARY KEY, university VARCHAR(40), studentname VARCHAR(40), studentID VARCHAR(16), punchtime DATE);";
    //$sql_query_insertSignup = "insert into signupsheet(id, studentname, studentID) values('$id','aceyee','V00793984');";
    if(mysqli_query($con, $sql_query_CreateSheet)){
        //echo "Sheet Created Insertion Success ".$id;
    }else{
        echo "Failed to Create a Sheet";
    }
}else{
    echo "Data insertion error".mysqli_error($con);
}
?>