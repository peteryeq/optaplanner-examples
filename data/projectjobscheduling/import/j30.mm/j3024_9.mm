************************************************************************
file with basedata            : mf24_.bas
initial value random generator: 421726975
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  32
horizon                       :  237
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     30      0       31       24       31
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3           6   8  17
   3        3          1           5
   4        3          3           8  14  21
   5        3          3          20  21  26
   6        3          3           7  15  22
   7        3          3          10  12  18
   8        3          3           9  23  27
   9        3          1          28
  10        3          2          11  25
  11        3          2          28  31
  12        3          2          13  20
  13        3          3          14  16  24
  14        3          2          19  28
  15        3          2          16  30
  16        3          2          23  27
  17        3          1          22
  18        3          3          20  23  27
  19        3          3          25  29  30
  20        3          1          24
  21        3          1          22
  22        3          1          24
  23        3          1          25
  24        3          2          29  30
  25        3          1          26
  26        3          1          31
  27        3          1          31
  28        3          1          29
  29        3          1          32
  30        3          1          32
  31        3          1          32
  32        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     4       6    5    5    0
         2     5       5    3    5    0
         3     6       3    3    0   10
  3      1     4       8    6    0    9
         2     6       6    3   10    0
         3     8       1    1    0    9
  4      1     2       6    2    0   10
         2     6       3    1    1    0
         3     8       3    1    0    7
  5      1     2       8    8    0    9
         2     5       4    6    7    0
         3     7       4    2    0    9
  6      1     1       5    4    6    0
         2     4       5    3    5    0
         3     5       4    2    0    9
  7      1     3       1   10    0    9
         2     4       1    7    0    8
         3     9       1    6   10    0
  8      1     1       9    6    8    0
         2     7       7    6    0    4
         3     8       6    3    0    2
  9      1     1       2    6    0    6
         2     3       2    4    0    6
         3     6       2    2    0    5
 10      1     5       4    3    9    0
         2    10       1    2    0    5
         3    10       2    3    2    0
 11      1     4       5    8    3    0
         2     6       5    7    2    0
         3     7       5    7    0    3
 12      1     1       4    6    7    0
         2     4       3    6    0    1
         3    10       3    6    7    0
 13      1     2       9    4    7    0
         2     2       8    4    8    0
         3     7       3    2    6    0
 14      1     3      10    4    0   10
         2     4      10    2    4    0
         3    10       9    2    0    5
 15      1     1       6    2    7    0
         2     3       3    2    0    9
         3     7       1    2    0    3
 16      1     1       6    2    5    0
         2     3       3    2    0    6
         3     4       3    1    5    0
 17      1     2       9    7    0    6
         2     3       6    5    0    5
         3     4       1    4    7    0
 18      1     1       7    8    6    0
         2     5       5    7    0   10
         3     6       4    6    0    7
 19      1     5       4    7    6    0
         2     9       3    6    0    4
         3    10       2    6    4    0
 20      1     7       4    8    6    0
         2     7       4    8    0    7
         3     9       3    7    0    7
 21      1     3      10    9    6    0
         2     5       9    8    0    8
         3     6       8    6    0    5
 22      1     8       9   10    9    0
         2     8       9   10    0    7
         3    10       9   10    0    6
 23      1     3       7    7    0    9
         2     8       5    6    8    0
         3     8       6    7    6    0
 24      1     3       3    6    5    0
         2     5       3    6    4    0
         3     9       2    6    0    6
 25      1     3      10    6    0    7
         2     4      10    6    0    4
         3     7      10    5    0    3
 26      1     2      10    7    7    0
         2     2       9    6    9    0
         3    10       9    5    0    1
 27      1     8       5    2    4    0
         2     8       7    2    0    4
         3     9       2    2    0    4
 28      1     1       2    6    4    0
         2     6       2    5    0    9
         3     8       2    4    0    6
 29      1     7       7    6    0    9
         2     8       6    4    6    0
         3    10       5    3    0    9
 30      1     5       9    6    0    9
         2     7       9    5    0    6
         3    10       9    3    0    4
 31      1     7       8    9    0    6
         2     7       8   10    3    0
         3     9       7    9    0    8
 32      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   42   42  128  156
************************************************************************
