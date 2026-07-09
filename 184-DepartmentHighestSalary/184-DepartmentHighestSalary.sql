-- Last updated: 7/9/2026, 10:07:10 AM
SELECT
    d.name As department,
    e.name As Employee,
    e.salary As salary
From Employee e
Join Department d
    On e.DepartmentId =d.id
JOIN (
    SELECT departmentId, MAX(salary) AS max_salary
    FROM Employee
    GROUP BY departmentId
) m
ON e.departmentId = m.departmentId
AND e.salary = m.max_salary;


