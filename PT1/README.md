# Overview of Data Structures
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
# How to run code:
Windows and Linux:
```sh
# JDK should have been downloaded and changed directories to where the file is stored.
java <file name>
```
# How to operate
## BFS
| Inputs | Function |
| --- | --- |

## Min Heap
| Inputs | Function |
| --- | --- |

## Max Heap
| Inputs | Function |
| --- | --- |

## Linked Lists
| Inputs | Function |
| --- | --- |
[0]Exit |               stops the program |
[1]Create Node |        prompts the user to input a number |
[2]Delete last node |   deletes the last node / newly created node |
[3]Display all info |   displays the list and its following informations |

## Queue
| Inputs | Function |
| --- | --- |
| [0]Exit |             stops the program |
[1]Enqueue |            prompts the user to input a number |
[2]Dequeue |            deletes the bottom node of the queue / oldest node|
[3]Display Queue |      displays the list and its following informations |

## Searching
| Inputs | Function |
| --- | --- |
| [0]Exit |             stops the program |
| [1]Create Node |      prompts the user to input a number |
| [2]Search based on value | finds the index number based on the value inputted |
| [3]Display list |     displays the list and its following informations |

## Sorting 
| Inputs | Function |
| --- | --- |
| [0]Exit |             stops the program |
| [1]Create Node |      prompts the user to input a number |
| [2]Sort Nodes |       sorts the numbers based on the numbers inputted |
| [3]Display list |     displays the list and its following informations |

## Stack
| Inputs | Function |
| --- | --- |
| [0]Exit |             stops the program |
| [1]Push |             prompts the user to input a number |
| [2]Pop |              deletes the top node of the stack |
| [3]Display Stack |    displays the list and its following informations |
## Binary Tree 
| Inputs | Function |
| --- | --- |
| [0]Exit |             stops the program |
| [1]Insert |           prompts the user to input a number |
| [2]Display tree |     deletes the first node / oldest created node |

# Explanations
## BFS

## Min Heap

## Max Heap

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

### There are 2 functions within the code:
- display()
The display function outputs the tree using a Level Order Traversal. It checks first if the tree is empty and it prints out a message if so.
example:

        
- insert()












