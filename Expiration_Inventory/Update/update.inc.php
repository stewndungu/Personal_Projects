
<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    echo '<pre>';
    print_r($_POST);
    echo '</pre>';
    
    if (!empty($_POST["Id"]) && !empty($_POST["Calendar"]) ) {
        $updateId = $_POST["Id"];
        $updateCalendar = $_POST["Calendar"];
        $insertTable= $_POST["Area"];
       
    }
    else
    {
        echo "Required form data is missing or empty.";
    }
        try {
            // Connect to the database
            require_once("../dbh.inc.php");

            // The query
        //  $query = "UPDATE tobacco SET Calendar = :Calendar WHERE Brand = :Brand AND Label = :Label";
        $query = "UPDATE $insertTable SET Calendar = :Calendar WHERE ID = :Id";
            // Prepare the query
            $stmt = $pdo->prepare($query);
            //  $stmt->bindParam(":Brand", $updateBrand);
             $stmt->bindParam(":Id", $updateId);
            $stmt->bindParam(":Calendar", $updateCalendar);

            // Execute the statement
            $stmt->execute();

            // Close the connection
            $pdo = null;
            $stmt = null;
            
         header("Location: ../website.php");
         die();
           
        }
        catch(PDOException $e) {
            die("Query failed: " . $e->getMessage());
        }
    
}
else {
    header("Location: ../website.php");
    
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" >
    <!-- link to the style css file-->
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
        

        
</body>


</html>