select case when (C>A+B or C<=abs(A-B)) then 'Not A Triangle' 
when (A>C+B or A<=abs(C-B)) then 'Not A Triangle' 
when (B>C+A or B<=abs(C-A)) then 'Not A Triangle' 
when (A=B and A=C and B=C) then 'Equilateral' 
when (A=B or A=C or B=C) then 'Isosceles' 
when (A<>B and A<>C and B<>C) then 'Scalene' end 
from triangles;