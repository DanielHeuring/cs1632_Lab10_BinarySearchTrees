Results of 10 Test Runs:
------------------------

Run 1;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     12.10              7.3440                  
1000       10         100000     21.30              11.9388                 
10000      10         100000     29.90              16.5075                 

Process finished with exit code 0

Run 2;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     12.80              7.4850                  
1000       10         100000     21.40              11.9548                 
10000      10         100000     29.50              16.4440                 

Process finished with exit code 0

Run 3;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     12.00              7.3000                  
1000       10         100000     22.30              12.5730                 
10000      10         100000     30.10              16.4910                 

Process finished with exit code 0

Run 4;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     12.70              7.2470                  
1000       10         100000     21.60              12.0375                 
10000      10         100000     30.60              16.5837                 

Process finished with exit code 0

Run 5;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     11.90              7.5390                  
1000       10         100000     21.00              11.9978                 
10000      10         100000     30.40              16.5598                 

Process finished with exit code 0

Run 6;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     13.10              7.6600                  
1000       10         100000     20.90              11.9940                 
10000      10         100000     29.60              16.3510                 

Process finished with exit code 0

Run 7;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     11.60              7.1700                  
1000       10         100000     20.70              11.6795                 
10000      10         100000     30.00              16.1308                 

Process finished with exit code 0

Run 8;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     12.30              7.4400                  
1000       10         100000     21.10              12.0971                 
10000      10         100000     29.70              16.2038                 

Process finished with exit code 0

Run 9;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     12.10              7.3400                  
1000       10         100000     20.60              11.9336                 
10000      10         100000     30.60              16.5794                 

Process finished with exit code 0

Run 10;
N          Trials     Range K    Avg Tree Height    Avg Nodes / Find        
---------------------------------------------------------------------------
100        10         100000     11.50              7.2560                  
1000       10         100000     20.40              11.6999                 
10000      10         100000     29.90              16.5313                 

Process finished with exit code 0

**Takeaway**
When comparing the data from the different trials, there is a clear pattern that starts to show.
We can see that even though the number of elements is increasing substantially, the tree height itself
is actually increasing much less per each element added to N. I think this does a good job of illustrating
the logarithmic growth of binary search trees and why they can be so powerful with large sets of unsorted data

The data is also really consistent when it comes to how many nodes it takes to find a value. Averaging ~16.4 
nodes per find being consistently the number it takes for a tree with 10000 elements.
