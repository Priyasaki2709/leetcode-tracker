-- Last updated: 7/9/2026, 10:07:12 AM
SELECT email As Email
From Person
GROUP BY email
HAVING COUNT(email)>1;