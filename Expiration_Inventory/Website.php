


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" >
    <!-- link to the style css file-->
    <link rel="stylesheet" href="style.css">
</head>

<body>
<!-- ading moving video background-->
    <video autoplay muted loop>
    <source src="Image/0_Abstract_Technology_1080X1080.mp4" type="video/mp4">
    </video>

    <nav class="navigation"> 
        <ul >
                    
                    <li><a class="active" href="Website.php">Home</a></li>
                    
        </ul>

    </nav>
    
        <!-- Division for brand -->
            <div class="Brand">
                
                 <form class="Brands_input" action="search/search.php" method="post" >
                        <select id="Area" name="Area">
                        <!--  choose which ever name you want for the values, but must match the categories in the database --> 
                        <option value="Tobacco">Tobacco</option>
                        <option value="Medicine">Medicine</option>
                        <option value="Beverages">Beverages</option>
                        <option value="Groceries">Groceries</option>
                        <option value="others">Others</option>
                        </select><br><br>
                    <!-- Has a search bar and button to click --> 
                    <label>Brand</label>
                    <input type="text" id="brand" name="searchBrand">
                    <button>Search</button> <br><br>
                 </form>
            </div>

        <!-- Division for Name -->
            <div class="Name">
                
                <form class="Names_input" action="search/search.php" method="post" > 
                    <select id="Area" name="Area">
                    <option value="Tobacco">Tobacco</option>
                    <option value="Medicine">Medicine</option>
                     <option value="Beverages">Beverages</option>
                     <option value="Groceries">Groceries</option>
                    <option value="others">Others</option>
                </select><br><br>
                     <!-- Has a search bar and button to click --> 
                    <label>Name</label>
                    <input type="text" id="name" name="searchLabel">
                    <button>Search</button> <br><br>
                </form>
            </div>
            
        <!-- Division for DAte -->    
            <div class="Date">
                
                <form class="Dates_input" action="search/search.php" method="post">
                    <select id="Area" name="Area">
                    <option value="Tobacco">Tobacco</option>
                    <option value="Medicine">Medicine</option>
                     <option value="Beverages">Beverages</option>
                     <option value="Groceries">Groceries</option>
                    <option value="others">Others</option>
                </select><br><br> 
                     <!-- Has a calendar to choose a date and button to click --> 
                    <label>Date</label>
                    <input type="text" id="date" name="searchCalendar" placeholder="YYYY-MM-DD">
                    <input type="submit" Value="Search"><br><br>
                </form>
            </div>
       
            <br><br><br><br><br><br><br><br><br><br><br><br>
            <p class="explain"> To update the Items: Use the any search bar above to find the item's Id. It is a numeric value
                Then enter that into the Id bar above the date bar and click update

             </p>
       
       <div class="update">
            
            <form class="Update_input" action="Update/update.inc.php" method="POST"  >
                
             <select id="Area" name="Area">
                        <option value="Tobacco">Tobacco</option>
                        <option value="Medicine">Medicine</option>
                        <option value="Beverages">Beverages</option>
                        <option value="Groceries">Groceries</option>
                        <option value="others">Others</option>
                        </select><br><br>
                <input type="text" name="Id" placeholder="Identity"> <br><br>
    
                <input type="text"  name="Calendar" placeholder="YYYY-MM-DD"> <br><br>
                <input type="submit" value="Update" > 

            </form>
           
       </div>
       
       <div class="delete">
            
            <form class="delete_input" action="Delete/delete.inc.php" method="POST"  >
             <select id="Area" name="Area">
                        <option value="Tobacco">Tobacco</option>
                        <option value="Medicine">Medicine</option>
                        <option value="Beverages">Beverages</option>
                        <option value="Groceries">Groceries</option>
                        <option value="others">Others</option>
                        </select><br><br>
                
                <input type="text" name="Brand" placeholder="Brand"><br><br>
                <input type="text" name="Label" placeholder="Name"> <br><br>
                
                <input type="submit" value="Delete" > 

            </form>
       </div>

       
       <div class="insert">
            
            <form class="insert_input" action="Insert/insert.inc.php" method="POST"  >
           
                <select id="Area" name="Area">
                    <option value="Tobacco">Tobacco</option>
                    <option value="Medicine">Medicine</option>
                     <option value="Beverages">Beverages</option>
                     <option value="Groceries">Groceries</option>
                    <option value="others">Others</option>
                </select><br><br>
                <input type="text" name="Brand" placeholder="Brand"> <br><br>
                <input type="text" name="Label" placeholder="Name"> <br><br>
                <input type="text"  name="Calendar" placeholder="YYYY-MM-DD"> <br><br>
                
                <input type="submit" value="Insert" > 

            </form>
       </div>
       
</body>


</html>

