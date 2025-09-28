use inventory;
SELECT id,brand,label, Calendar, '** some table **' AS source
FROM tobacco
WHERE Calendar BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)

UNION ALL

SELECT id,brand,label, Calendar, ''** some table **' AS source
FROM medicine
WHERE Calendar BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)

UNION ALL

SELECT id,brand,label, Calendar, ''** some table **' AS source
FROM beverages

WHERE Calendar BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH);
