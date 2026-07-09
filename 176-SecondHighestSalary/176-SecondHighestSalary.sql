-- Last updated: 7/9/2026, 10:07:20 AM
SELECT
(
  SELECT DISTINCT salary
  FROM Employee
  ORDER By salary DESC
  LIMIT 1 OFFSET 1
)As SecondHighestSalary
 