# Overview of Data Structures
- Graph
    - Undirected Graph
- Heap
    - Min Heap
    - Max Heap
- Linked List
    - Circular Linked List
    - Doubly Linked List
    - Singly Linked List
- Queues
    - Priority Queue
    - Simple Queue
- Searching Algorithm
    - Linear Search
- Sorting Algorithm
    - Bubble Sort
- Stack
    - Stack
- Trees
    - Binary Tree
# How to run code:
Windows and Linux:
```sh
# JDK should have been downloaded and changed directories to where the file is stored.
java <file name>
```
# How to operate
## Undirected Graph
- Asciinema video examples
[Undirected Graph](https://asciinema.org/a/YBWko1xcUXjYi8UdzsiXkTdVg)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a source and destination |
| 2 | display the graph in Adjacency list representation |

## Heaps
- Asciinema video examples
[Min Heap](https://asciinema.org/a/qfrKzzuTXggWNSBBsz0uQhoCM)

[Max Heap](https://asciinema.org/a/FhZcTvuIbsIldrGPmuRtUE2ya)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | displays the heap using BFS|

## Linked Lists
- Asciinema video examples
[Singly Linked List](https://asciinema.org/a/BS7q8J4mPjMC20g9Flxa7lAzo)

[Doubly Linked List](https://asciinema.org/a/4WFUXAsSXZe7Xkkf51lVlEc2u)

[Circular Linked List](https://asciinema.org/a/gRNaSgEIkI7Z5jKBnktGbLLoq)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | deletes the last node / newly created node |
| 3 | displays the list and its following informations |

## Queue
- Asciinema video examples
[Sinmple Queue](https://asciinema.org/a/P8VmmyN9pvwEn0ru3lGAa1YAw)

[Priority Queue](https://asciinema.org/a/oxe9fjP2jM1z1Qaqe9jVGVjHB)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | deletes the bottom node of the queue / oldest node|
| 3 | displays the list and its following informations |

## Searching
- Asciinema video examples
[Linear Search](https://asciinema.org/a/FVvMF6hfPapX03sUWQZCjol7a)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | finds the index number based on the value inputted |
| 3 | displays the list |

## Sorting 
- Asciinema video examples
[Bubble Sort](https://asciinema.org/a/LWdECVbXX28AgH4lJxe8s16kp)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | sorts the numbers based on the numbers inputted |
| 3 | displays the list and its following informations |

## Stack
- Asciinema video examples
[Stack](https://asciinema.org/a/WzkmppTsfAW7A31LbZTEaFBQa)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | deletes the top node of the stack |
| 3 | displays the stack and its following informations |
## Binary Tree 
- Asciinema video examples
[Binary Tree](https://asciinema.org/a/4DvgBdsiSd3zF611VhgjPrDSF)

| Inputs | Function |
| :-: | --- |
| 0 | stops the program |
| 1 | prompts the user to input a number |
| 2 | displays the tree |

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
example:

        Adjacency List Representation:
        0: 1, 2, 3
        1: 0, 3
        2: 0
        3: 0, 1
## Min Heap
A Min Heap is a binary heap data structure where the root node is the smallest element. Each parent node is smaller than or equal to its child nodes. This property ensures that the minimum element is always at the root.
### There are 2 functions within the code:

- insert()
This fuction adds the value to the heap based on the user input and swaps the parent node to the child node if the parent node is greater than the child node. It then repeats this swapping until it is a min-heap.
example:

        Enter value to insert: 2
        Inserted 2 into the min-heap.

- display()
The display function outputs the heap using a Level Order Traversal. It checks first if the heap is empty and it prints out a message if so.
example:

        Current min-heap: 0 1 8 2  


## Max Heap
A Max Heap is a binary heap data structure where the root node is the largest element. Each parent node is larger than or equal to its child nodes. This property ensures that the maximum element is always at the root.
### There are 2 functions within the code:
- insert()
This fuction adds the value to the heap based on the user input and swaps the parent node to the child node if the parent node is less than the child node. It then repeats this swapping until it is a min-heap.
example:

        Enter value to insert: 2
        Inserted 2 into the max-heap.

- display()
The display function outputs the heap using a Level Order Traversal. It checks first if the heap is empty and it prints out a message if so.
example:

        Current max-heap: 8 2 1 0  

## Circular Linked List
A Circular Linked List is a data structure that connect the pointer of the tail to the head forming a loop and it allows continuous traversal. It consists of the the data and the pointer that holds the memory adress to the next node. This creates a list that is connected only on one side.
example:

    0 -> 1 -> head 
    head:0
    
### There are 3 functions within the code:
- display() 
The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that currently is existing. 
- createNewNode()
The create New Node function creates a node at the tail replacing the newly created node as the tail, changing the pointer of the previous tail to the current tail, and making the pointer of the newly created node to the head. If the list is empty, the created node becomes the head and tail while its pointer is the head.
    example:

        value:  2
        before: 0 -> 1 -> head
        after:  0 -> 1 -> 2 -> head
- deleteNewNode()
The delete new node function basically deletes the tail, the second to last node becomes the tail and its pointer is set to the head. A message will print if there are no Nodes to remove.
example:

        before: 1 -> 2 -> 3 -> head
        after:  1 -> 2 -> head
    
## Doubly Linked List
A Doubly Linked List is a data structure that consists of the the data and the pointer that holds the memory adress to the next node and the pointer to the previous node. The next pointer of the last node is null indicating the end of the list, while the previous pointer of the first node is null.
example:

    null <- 0 - 1 -> null 
    
### There are 3 functions within the code:
- display() 
The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that currently is existing. 
- createNewNode()
The create New Node function creates a node at the tail replacing the newly created node as the tail, changing the pointer of the previous tail to the current tail, making the next pointer of the newly created node to null, and making the previous pointer of the newly created node to the previous tail. If the list is empty, the created node becomes the head and tail while its next and previous pointer is null.
example:

        value:  2
        before: null <- 0 - 1 -> null
        after:  null <- 0 - 1 - 2 -> null
- deleteNewNode()
The delete new node function basically deletes the tail, the second to last node becomes the tail and its next pointer is set to the null while the previous pointer of the tail becomes null. A message will print if there are no Nodes to remove.
example:

        before: null <- 1 - 2 - 3 -> null
        after:  null <- 1 - 2 -> null

## Singly Linked List
A Singly Linked List is a data structure that consists of the the data and the pointer that holds the memory adress to the next node. The pointer of the last node is null, indicating the end of the list.
example:

    0 -> 1 -> null 
    
### There are 3 functions within the code:
- display() 
The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that currently is existing. 
- createNewNode()
The create New Node function creates a node at the tail replacing the newly created node as the tail, changing the pointer of the previous tail to the current tail, and making the pointer of the newly created node to null. If the list is empty, the created node becomes the head and tail while its pointer is null.
example:

        value:  2
        before: 0 -> 1 -> null
        after:  0 -> 1 -> 2 -> null

- deleteNewNode()
The delete new node function basically deletes the tail, the second to last node becomes the tail and its pointer is set to the null. A message will print if there are no Nodes to remove.
example:

        before: 1 -> 2 -> 3 -> null
        after:  1 -> 2 -> null

## Priority Queue
A Queue is a linear data structure FIFO (First In First Out) Principle, so the first element inserted is the first to be popped out. What makes it different from simple queue is its priority index that arranges the elements based on their priority value. 
### There are 3 functions within the code: 
- display() 
The display function outputs the nodes created by itterating from the top of the list to the bottom. It also display the top of the queue. If the list is empty, it will return a message signifying that there are no elements that currently is existing. 
- enqueue()
The enqueue function places the new element based on the value of its priority. It reapetedly compare if the new element is greater than the bottom and if it is not, the new element then moves from the bottom of the queue till the top until it finds an equal or bigger number. 
example:

        value:   2   priority: 9
        before:  0 <- 1 <- null
        priority:6 <- 5         
        
        after:   2 <- 0 <- 1 <- null 
        priority:9 <- 6 <- 5 
- dequeue()
The dequeue function removes the top of the queue and changes the top of the queue to the second to the top element. If the queue is empty, a message will print out.
example:
        
        before: 0 <- 1 <- 2 <- null
        after:  1 <- 2 <- null

## Simple Queue
A Queue is a linear data structure FIFO (First In First Out) Principle, so the first element inserted is the first to be popped out.
### There are 3 functions within the code:
- display() 
The display function outputs the nodes created by itterating from the top of the list to the bottom. It also display the top of the queue. If the list is empty, it will return a message signifying that there are no elements that currently is existing. 
- enqueue()
The enqueue function creates a new element at the bottom of the queue and change the next pointer of the previous bottom to the new one. If the top of the queue is null, then it means that the queue is empty and the newly created element becomes the top and bottom of the queue. 
example:

        value:  2
        before: 0 <- 1 <- null
        after:  0 <- 1 <- 2 <- null
- dequeue()
The dequeue function removes the top of the queue and changes the top of the queue to the second to the top element. If the queue is empty, a message will print out. 
example:

        before: 0 <- 1 <- 2 <- null
        after:  1 <- 2 <- null

## Linear Search

### There are 3 functions within the code:
- display()
The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that currently is existing. 
- insert()
The insert function creates a node at the tail replacing the newly created node as the tail, changing the pointer of the previous tail to the current tail, and making the pointer of the newly created node to null. If the list is empty, the created node becomes the head and tail while its pointer is null.
example:

        value:  2
        before: 0 -> 1 -> null
        after:  0 -> 1 -> 2 -> null
- search()
The search function finds the index number based on the given value. It itterates from the head of the list to the tail comparing the values and if it doesn't exist, a message will pop up notifying the user. 
example:

        value:  9
        list:   0, 3, 9, 5

        value is at index[2]

## Bubble Sort

### There are 3 functions within the code:
- display()
The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that currently is existing. 
- insert()
The insert function creates a node at the tail replacing the newly created node as the tail, changing the pointer of the previous tail to the current tail, and making the pointer of the newly created node to null. If the list is empty, the created node becomes the head and tail while its pointer is null.
example:

        value:  2
        before: 0, 1
        after:  0, 1, 2
- sort()
The sort function reapetedly compares the adjacent node if it is greater than the compared number. It then swaps the two numbers and repeat it again to the next node. This is repeated till it loops without changes signifying that there is no more left to sort.
example:

        before: 9, 8, 7, 6, 1
        after:  1, 6, 7, 8, 9

## Stack

### There are 3 functions within the code:
- display()
The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that currently is existing. 
- push()
The push function creates a new element at the top of the stack and change the next pointer of the previous top to the new one. If the top of the stack is null, then it means that the stack is empty and the newly created element becomes the top and bottom of the stack. 
example:

        value:  2
        before: 0 <- 1 <- null
        after:  2 <- 0 <- 1 <- null
- pop()
The dequeue function removes the top of the qustack and changes the top of the stack to the second to the top element. If the stack is empty, a message will print out. 
example:

        before: 0 <- 1 <- 2 <- null
        after:  1 <- 2 <- null

## Binary Tree 

### There are 3 functions within the code:
- display()
The display function outputs the tree using a Level Order Traversal. It checks first if the tree is empty and it prints out a message if so.
example:

        root: 9
        level 1: 8
        level 2: 7
- insert()
The insert function firstly asks the user to prompt the node of the tree. Afterwards, it then asks if the user wants to insert a value to the left and right of the root. if the user agrees, it recursively calls the function till the user disagrees.
example:

        Enter root node: 9
         
        Do you want to enter left of 9: y
        Enter the value of the left of 9: 8
        
        // Output
        root: 9
        level 1: 8

- getYesNoInput()
This function basically scans if the user inputted a y or n. If they inputted anything apart from y and n, the function will restart again to get user validation.


