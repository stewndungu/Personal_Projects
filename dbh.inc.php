<?php
// post

// so some variable dsn connects to mysql 127.0.0.1 and the connect to databse called website
$dsn="mysql:host=127.0.0.1;dbname=inventory";
//there isnt a username
$dbusername ="root";
// but there is a password
$dbpass = "";

try{
    //trying to connect to the database with the login stuff
        $pdo = new PDO($dsn, $dbusername, $dbpass);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}
catch(Exception $e){
    //error message
    echo "Connection failed: " .$e->getMessage();

}

