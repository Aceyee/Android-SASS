<?php
    require "init2.php";

    $name = "SSS";
    $search_input = $_POST["searchinput"];

    //$sql_query = "SELECT course from session WHERE course like '$search_input';";
    $sql_query = "SELECT * from session WHERE REPLACE(course, ' ', '') = REPLACE('$search_input', ' ', '');";
    $result = mysqli_query($con, $sql_query);
    $response = array();

    if(mysqli_num_rows($result)>0){
        while($row = mysqli_fetch_array($result)){
            array_push($response, array("university"=>$row[0], "course"=>$row[1], "professor"=>$row[2]));
        }
        echo json_encode(array("Search Success"=>$response));
    }else{
        echo "Search Fail. No Result";
    }
?>