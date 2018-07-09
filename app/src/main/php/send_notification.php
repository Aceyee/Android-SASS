<?php
    require "init.php";
    $message = $POST["message"];
    $title = $POST["title"];
    $path_to_fcm = 'https://fcm.googleapis.com/fcm/send';
    $server_key = "AAAAfOdXBmo:APA91bEi32-kdAP-eKvWuUo6YnaDwRXRjpYFb1fMDCVzo8eUlkGS51-9AZoyXwR5hK58N6Vh-KcaUKbyFjQVs3ocu-eFbCygijvtW9oyR7CCsNazWzAZQIuA7zH8XesuDzRXXXugdmzmvoLaVesSZHPA2Yo77cMrYw";
    $sql = "SELECT fcm_token from fcm_info";
    $result = mysqli_query($con, $sql);
    $row = mysqli_fetch_row($result);
    $key = $row[0];

    $headers = array(
        'Authorization:key=' .$server_key,
        'Content-Type:application/json'
    );
    $fields = array(
        'to' => $key,
        'notification'=>array('title'=>$title,'body'=>$message)
    );
        
    $payload = json_encode($fields);

    $$curl_session = curl_init();

    curl.setopt($cur_session, CURLOPT_URL, $path_to_fcm);
    curl.setopt($cur_session, CURLOPT_POST, true);
    curl.setopt($cur_session, CURLOPT_HTTPHEADER, $headers);
    curl.setopt($cur_session, CURLOPT_RETURNTRANSFER, true);
    curl.setopt($cur_session, CURLOPT_SSL_VERIFYPEER, false);
    curl.setopt($cur_session, CURLOPT_IPRESOLVE, CURL_IPRESOLVE_V4);
    curl.setopt($cur_session, CURLOPT_POSTFIELDS, $payload);

    $result = curl_exec($curl_session);

    curl_close($curl_session);
    mysqli_close($con);



?>