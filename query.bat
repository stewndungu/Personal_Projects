use inventory;
SELECT id,brand,label, Calendar, 'tobacco' AS source
FROM tobacco
WHERE Calendar BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)

UNION ALL

SELECT id,brand,label, Calendar, 'medicine' AS source
FROM medicine
WHERE Calendar BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)

UNION ALL

SELECT id,brand,label, Calendar, 'beverages' AS source
FROM beverages
WHERE Calendar BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH);