## Network algorithm

Project contains class Network. 
The constructor should take a positive integer value indicating the number of elements in the set. Passing in an invalid value throws IllegalArgumentException.
The class provides two public methods:
_**connect**_ - takes two integers indicating the elements to connect. Method throws IllegalArgumentException unless both (0 < p <= n) and (0 < q <= n)
_**query**_ - takes two integers and returns true if the elements are connected, directly or indirectly, and false if the elements are not connected. Method throws IllegalArgumentException unless both (0 < p <= n) and (0 < q <= n)

Command _**mvn test**_ for start unit testing