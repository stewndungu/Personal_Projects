<?php

if($_SERVER["REQUEST_METHOD"]== "POST" )
{
   
    //check if the name attribute in the individual ####_input forms are set with those names
    if(isset($_POST["searchBrand"]) && !empty($_POST["searchBrand"]))
    {
         $insertTable= $_POST["Area"];
        // sanitize input
        $searchbrand=htmlspecialchars(trim($_POST["searchBrand"]));
        try{
            // connect to this page to go to the database
            require_once("../dbh.inc.php");

            // the query
            $query="SELECT * FROM $insertTable WHERE Brand LIKE :searchBrand";
            // prepares the query
            $stmt = $pdo->prepare($query);
            $stmt->bindParam(":searchBrand", $searchbrand);

            //executes the statement
            $stmt->execute();

                // get any that applies to the query
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

            // change the variables to null so it isnt a security issue
            $pdo=null;
            $stmt=null;
            


        }
        catch(PDOException $e){
            die("Query failed: ". $e->getMessage());
        }
    }
    elseif(isset($_POST["searchLabel"]) && !empty($_POST["searchLabel"]))
    {
        $insertTable= $_POST["Area"];
        
        // sanitize input
        $searchname=htmlspecialchars(trim($_POST["searchLabel"]));
        try{
            // connect to this page to go to the database
            require_once("../dbh.inc.php");
    
            // the query
            $query="SELECT * FROM $insertTable WHERE Label LIKE :searchLabel";
            // prepares the query
            $stmt = $pdo->prepare($query);
            $stmt->bindParam(":searchLabel", $searchname);
    
            //executes the statement
            $stmt->execute();
    
                // get any that applies to the query
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
    
            // change the variables to null so it isnt a security issue
            $pdo=null;
            $stmt=null;
            
    
    
        }
        catch(PDOException $e){
            die("Query failed: ". $e->getMessage());
        }
    }
    elseif(isset($_POST["searchCalendar"]) && !empty($_POST["searchCalendar"]))
    {
        $insertTable= $_POST["Area"];
        $searchcalendar=htmlspecialchars(trim($_POST["searchCalendar"]));
        

        try{
            // connect to this page to go to the database
            require_once("../dbh.inc.php");
    
            // the query
            $query="SELECT * FROM $insertTable WHERE Calendar = :searchCalendar";
            // prepares the query
            $stmt = $pdo->prepare($query);
            $stmt->bindParam(":searchCalendar", $searchcalendar);
    
            //executes the statement
            $stmt->execute();
    
                // get any that applies to the query
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
    
            // change the variables to null so it isnt a security issue
            $pdo=null;
            $stmt=null;
            
            
    
    
        }
        catch(PDOException $e){
            die("Query failed: ". $e->getMessage());
        }
    }

}
else{
    header("Location ../website.php");
}


?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" >
    <!-- link to the style css file-->
    <link rel="stylesheet" href="../style.css">
</head>
<body>
<nav class="navigation"> 
        
         <ul>          
        <li><a class="active" href="../Website.php">Home</a></li>
        </ul> 

</nav>
    <video autoplay muted loop>
        <source src="../Image/0_Abstract_Technology_1080X1080.mp4" type="video/mp4">
        </video>
    <h1>Results</h1>

    
        
            <?php
            if (empty($result))
            {
                echo "<div>";
                echo"<p> there were no results!</p>";
                echo "</div>";
            }
            else{
                //print the results
                foreach($result as $row)
                {
                    // so this htmlspecialchars helps sanitize the output
                    echo"<div>";
                    echo htmlspecialchars( $row["ID"]) . "&nbsp &nbsp";
                    echo htmlspecialchars( $row["Brand"]) . "&nbsp &nbsp";
                    echo htmlspecialchars( $row["Label"]) . "&nbsp &nbsp";
                    echo htmlspecialchars( $row["Calendar"]);
                    echo "</div>";
                }
            }
        ?>
        
   
        
</body>


</html>



