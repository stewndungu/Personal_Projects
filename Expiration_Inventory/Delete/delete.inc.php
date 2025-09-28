<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
   
    
    if (!empty($_POST["Brand"]) && !empty($_POST["Label"]) ) {
        $deleteBrand = $_POST["Brand"];
        $deleteLabel = $_POST["Label"];
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
        $query = "DELETE FROM tobacco WHERE Brand = :Brand AND Label =:Label";
            // Prepare the query
            $stmt = $pdo->prepare($query);
            //  $stmt->bindParam(":Brand", $updateBrand);
             $stmt->bindParam(":Brand", $deleteBrand);
            $stmt->bindParam(":Label", $deleteLabel);

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