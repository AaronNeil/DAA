## Simple project of data structures written in java
#### Overview of Data Structures
- Graph
    - BFS
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

## Explanations
#### BFS
#### Min Heap
#### Max Heap
#### Circular Linked List
    A Circular Linked List is a data structure that that connect the pointer of the tail to the head forming a loop and it allows 
    continuous traversal. It consists of the the data and the pointer field pointing to the next node. This creates a list that is 
    connected only on one side.
    example:
    0 -> 1 -> head 
    head:0
    
There are 3 functions within the code:
##### display() 
    The display function outputs the nodes created by itterating from the head of the list to the tail. It also display informations 
    such as the head, tail, and the list size. If the list is empty, it will return a message signifying that there are no nodes that 
    currently is existing. 
##### createNewNode()
    The create New Node function creates a node at the tail replacing the newly created node as the tail, changing the pointer of the 
    previous tail to the current tail, and making the pointer of the newly created node to the header. If the list is empty, the 
    created node becomes the head and tail while its pointer is null.
    
    value: 2
    before: 0 -> 1 -> head
    after:  0 -> 1 -> 2 -> head
##### deleteNewNode()
    The delete new node function basically deletes the tail, the second to last node becomes the tail and its pointer is set to the
     head. A message will print if there are no Nodes to remove.
    
    before: 1 -> 2 -> 3 -> head
    after:  1 -> 2 -> head
    
#### Doubly Linked List
#### Singly Linked List
#### Priority Queue
#### Simple Queue
#### Linear Search
#### Bubble Sort
#### Stack
#### Binary Tree 











