-- Last updated: 7/9/2026, 10:07:18 AM
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N=N-1;
  RETURN (
    SELECT DISTINCT salary
    From Employee
    Order By salary DESC
    LIMIT 1 OFFSET N
  );
END