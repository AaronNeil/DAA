# **GRAPH**
// explanation of graph


# How to operate

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a source and destination |
| 2 | display the graph in Adjacency list representation |

# Explanations
## Undirected Graph
A Graph is a non-linear data structure consisting of vertices which contains the data and the edges that connects any two vertices together. An undirected graph is basically a graph where its edges have no specified direction assigned to it.  
### There are 2 functions within the code:
- addEdge()
This functions promprs the user to input the source and destination vertices and ensures that the user has inputted a number. It then adds an edge between the source and destination vertices in the adjacency list representation of the graph.
example:

        Enter source vertex: 0
        Enter destination vertex: 1
        Edge added between 0 and 1

- display()
This functions prints the adjacency list representation of the graph. It is done by itterating through the adjacency list and prints each vertex and its connected vertices.
example output:

        Adjacency List Representation:
        0: 1, 2, 3
        1: 0, 3
        2: 0
        3: 0, 1

## Analysis