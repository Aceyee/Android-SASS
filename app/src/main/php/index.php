<?php
     $lang = substr($_SERVER['HTTP_ACCEPT_LANGUAGE'], 0, 4);
    if (preg_match("/zh-c/i", $lang)){
        require("./zh/nav.htm"); 
        require("./zh/body.htm"); 
    } 
    else if (preg_match("/en/i", $lang)){   
        require("./en/nav.htm"); 
        require("./en/body.htm"); 
    }  
?>
