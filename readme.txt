Written by Catherine Leung for Yodle Jugglefest challenge as part of internship interview. 

To run, open cmd in the bin folder of the files and type : java juggleFestSol input.txt
The output will be in output.txt of the bin folder of the files.

This challenge was solved with a modified Gale-Shapley algorithm. The G-S algorithm only considers matching 1-1, but juggle fest requires that circuits be matched with a certain number of jugglers. In this case it is 6 per circuit. First, the input file was processed into jugglers and circuits. Jugglers already had predefined preferences, but a processList was also defined that included all other circuits in random order in case the jugglers could not be matched up with their top preferred circuits. To create a preference list for circuits, the dot product was calculated between each circuit and juggler and inputted into a hashtable for O(1) extraction.

To perform the matching, each juggler would attempt to match up with their top choice from their processList. They could propose only once to each circuit. If the circuit is not full, they will be automatically matched and added to the circuit's priority queue of matchings. A priority queue was chosen for automatic sorting of the jugglers so that the first one is the lowest ranked. (To improve run time, a minheap can be used for O(logn) insert rather than O(nlogn), or an array that is to be sorted only when necessary rather than upon every insert). If the circuit is full, then their ranking will be compared with the min juggler of that circuit's matches. If greater, then the juggler is swapped in. This ensures that jugglers will not only be matched according to preferences, but also according to their compatability with each circuit.

All classes have their fields set to private to prevent changes, which resulted in many getters and setters. Although it may not matter for this particular challenge, it is important coding practice to hide these fields to prevent other functions from changing these fields easily. 

Jugglers matched up with circuit 1970 are : J2594, J2602, J4445, J4761, J6510, J7850. The sum is 28762. 