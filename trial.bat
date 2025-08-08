
set filename=report_%date:~-10,2%_%date:~-7,2%_%date:~-4,4%_%time:~0,2%%time:~3,2%.txt
cd C:\xampp\mysql\bin
mysql -u root -h 127.0.0.1 < "C:\Users\Owner\Desktop\query.sql"  >> "C:\Users\Owner\Desktop\Inventory_reports\%filename%"

