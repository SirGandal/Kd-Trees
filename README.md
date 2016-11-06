# Kd-Trees
http://coursera.cs.princeton.edu/algs4/assignments/kdtree.html

Programming Assignment 5 for the "Algorithms, Part I" course on Coursera.

[Problem specification](assignment/ProgrammingAssignment5_Specification.pdf) (Course starting date October 3rd, 2016).  
[Problem checklist](assignment/ProgrammingAssignment5_Checklist.pdf) (Course starting date October 3rd, 2016).

## The problem
Write a data type to represent a set of points in the unit square (all points have x- and y-coordinates between 0 and 1) using a 2d-tree to support efficient range search (find all of the points contained in a query rectangle) and nearest neighbor search (find a closest point to a query point).  

### Visualization of running algorithms 
Nearest (left) and Range (right) running on input80K.txt:  
<img src="src/resources/input80K_nearest.gif" width="400"> <img src="src/resources/input80K_range.gif" width="400">  

## Assessment Summary
Compilation:  PASSED  
Style:        PASSED  
Findbugs:     No potential bugs found.  
API:          PASSED  

Correctness:  21/21 tests passed  
Memory:       8/8 tests passed  
Timing:       42/42 tests passed  

Aggregate score: 100.00% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]  

------
(Note that for this project to work a reference to [algs4.jar](http://algs4.cs.princeton.edu/code/algs4.jar) has to be added.) 
