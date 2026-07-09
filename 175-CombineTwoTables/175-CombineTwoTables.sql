-- Last updated: 7/9/2026, 10:07:21 AM
SELECT
p.firstname,
p.lastname,
a.city,
a.state
FROM Person p
LEFT JOIN Address a
on a.personId =p.personId;