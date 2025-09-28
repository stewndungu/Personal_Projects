<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
   
    
    if (!empty($_POST["Brand"]) && !empty($_POST["Label"]) ) {
        $insertBrand = $_POST["Brand"];
        $insertLabel = $_POST["Label"];
        $insertCalendar= $_POST["Calendar"];
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
        $query = "INSERT INTO $insertTable (Brand,Label,Calendar) Values (:Brand,:Label, :Calendar)";
            // Prepare the query
            $stmt = $pdo->prepare($query);
            //  $stmt->bindParam(":Brand", $updateBrand);
             //$stmt->bindParam(':Area', $insertTable);
             $stmt->bindParam(":Brand", $insertBrand);
            $stmt->bindParam(":Label", $insertLabel);
            $stmt->bindParam(":Calendar", $insertCalendar);;

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