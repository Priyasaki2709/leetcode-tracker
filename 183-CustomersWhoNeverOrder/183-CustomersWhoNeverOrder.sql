-- Last updated: 7/9/2026, 10:07:11 AM
SELECT name AS customers
FROM Customers
WHERE id NOT IN(
    SELECT customerId
    FROM Orders
);