
set filename=report_%date:~-10,2%_%date:~-7,2%_%date:~-4,4%_%time:~0,2%%time:~3,2%.txt
cd C:\xampp\mysql\bin
mysql -u root -h 127.0.0.1 < "C:\path-to-querys.sql\query.sql"  >> "C:\Path-to-your-folder-with-items\%filename%"


