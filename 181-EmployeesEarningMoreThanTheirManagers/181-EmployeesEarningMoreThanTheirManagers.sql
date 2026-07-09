-- Last updated: 7/9/2026, 10:07:14 AM
SELECT e1.name As Employee
FROM Employee e1
Join Employee e2
on e1.Managerid =e2.id
Where e1.salary>e2.salary