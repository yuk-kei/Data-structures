# Trees

## Introduction

In this lesson, we will learn a hierarchical data structure known as a **Tree**. A tree consists of **nodes** (vertices) that are connected using pointers (edges). Trees are similar to Graphs; the key differentiating point is that a cycle cannot exist in a Tree.

The basic structure of a tree consists of the following components:

- **Nodes**: Hold data
- **Root**: The uppermost node of a tree
- **Parent Node**: A node which is connected to one or more nodes on the lower level (*Child Nodes*).
- **Child Node**: A node which is linked to an upper node (*Parent Node*)
- **Sibling Node**: Nodes that have the same *Parent Node*
- **Leaf Node** – A node that doesn’t have any *Child Node*

## Terminology Used in Trees

Here are some other common terminologies used in trees:

- **Sub-tree**:
  A subtree is a portion of a tree that can be viewed as a complete tree on its own. Any node in a tree, together with all the connected nodes below it, comprise a subtree of the original tree. Think of the sub-tree as an analogy for the term, **proper subset.**

- **Degree**:
  The degree of a node refers to the total number of *sub-trees* of a node

- **Depth**:
  The number of connections (edges) from the root to a node is known as the depth of that node.

- **Level**: 
  $$
  (DepthOfNode) +1
  $$
  

- **Height of a Node**:
  The maximum number of connections between the node and a leaf node in its path is known as the height of that node.
- **Height of a Tree**:
  The height of a tree is simply the height of its root node.

## Types of Trees

The most commonly used types are listed below:

- *N-ary Tree*
- *Balanced Tree*
- *Binary Tree*
- *BinarySearchTree*
- *AVL Tree*
- *Red-Black Tree*
- *2-3 Tree*

## N-ary Tree

In N-ary trees, each node can have child nodes anywhere from **0** to **N**. So if it’s a **2-ary** tree, commonly known as a **Binary Tree**, it can have a max. of **0-2** child nodes. Can you guess the value of N in the figure shown below?

## Balanced Tree

A balanced tree is a tree in which almost all leaf nodes are present at the same level. This condition is generally applied to all sub-trees. This means that all the sub-trees in a tree need to be balanced, no matter how many there are. Mathematically, it can be expressed as:
$$
Height(Tree)=O(log(nodes))
$$
Or in simpler words, make the tree “height-balanced”; i.e. the difference between the height of the left and right sub-trees of each node should not be more than **one.** Mathematically, it can be written as:
$$
∣Height(LeftSubTree)−Height(RightSubTree)∣<=1
$$

> A binary tree is height-balanced if, for each node in the tree, the difference between the height of the right subtree and the left subtree is at most one.