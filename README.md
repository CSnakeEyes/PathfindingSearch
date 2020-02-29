# Pathfinding Search

This code demonstrates how three famous pathfinding search algorithms work. The algorithms are:

* Breadth-First Search (BFS)
* Iterative Deepening Search (IDS)
* A* pathfinding algorithm
---

## Input

The only thing needed for this program to run is a .txt file containing a map in the following format:

* First line: Size of map (Rows, Columns)
    * Example: `5 8`
* Second line: Starting point (Row, Column)
    * Example: `0 0`
* Third line: Goal point (Row, Column)
    * Example: `5 5`
* Remaining lines: Map showing the cost that it takes to get to a desired point

**NOTE:**
All points within the file are delimited (separated) by a space (e.g., " ").


### File example

![](https://i.imgur.com/HVIgsux.png)
___

## How to run

In order to run this program you have to run the .jar file through CLI (Command Line Interface) in the following way:

###### >: `java -jar <map_name>.txt <method_name>`

Where method name can only be replaced by:

* "IDS" (Iterative Deepening Search)
* "BFS" (Breadth-First Search)
* "AS" (A* algorithm)

*Example*

###### >: `java -jar map1.txt IDS`