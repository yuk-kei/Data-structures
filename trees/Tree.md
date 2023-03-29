# Trees

## Introduction

In this lesson, we will learn a hierarchical data structure known as a **Tree**. A tree consists of **nodes** (vertices) that are connected using pointers (edges). Trees are similar to graphs; the key differentiating point is that a cycle cannot exist in a Tree.

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

### Steps to Check if Tree is Balanced

This is the list of steps to follow to find out if a tree is balanced or not:

1. Start from the `leaf` nodes and move towards the `root`.
2. Along with traversing the tree, compute the heights of the **left-subtree** and **right-subtree** of each node. The height of a leaf node is always **0**.
3. At each node, check if the difference in height between the left and right sub-tree is **more than 1**; if so, then it means that the tree is not balanced.
4. If you have completely traversed the tree and haven’t caught the above condition, then it shows that the tree is balanced. (The height difference between the left and right sub-trees is NOT more than 1.)



 ## Binary Tree

### Types of Binary Trees

- *Complete Binary Tree*
- *Full Binary Tree*
- *Perfect Binary Tree*



### Complete Binary Tree

A Binary Tree is said to be *complete* if it satisfies the following properties:

- All levels are filled except possibly the last one

- Nodes at the last level are as far left as possible

- The maximum number of nodes in a complete binary tree of height **“h”** are expressed as 
  $$
  2 ^{h+1} - 1
  $$
  
- The total number of non-leaf nodes in a complete binary tree of height **“h”** are expressed as 
  $$
  2 ^{h} - 1
  $$
  
- The maximum number of leaf nodes in a complete binary tree of height **“h”** is expressed as 
  $$
  2 ^{h}
  $$

- The nodes are present in between the range of:

$$
2^h <Nodes<2^{h + 1} −1
$$



### Full Binary Tree

A **full** or **proper** Binary Tree has the following characteristics:

- Every node has **0** or **2** children. No node can have 1 child.
- The total number of nodes in a Full Binary Tree of height **‘h’** can be expressed as:

$$
2ℎ+1≤total number of nodes≤2^{(ℎ+1)}−1
$$



### Perfect Binary Tree

A Binary Tree is said to be ***Perfect*** if it is ***Full*** and ***Complete***. Also note that,

- The total number of nodes in a perfect binary tree of height **‘h’** are given as: 
  $$
  2^{(ℎ+1)}−1
  $$
  
- The total number of leaf nodes are given as ***2^h*** or ***(n+1)/2***  where **‘n’** is the number of nodes.

  

There are many other advanced trees derived from the basic structure of binary trees. Some of the most common ones are:

- Skewed Binary Tree
- Binary Search Tree
- AVL Tree
- Two-Three Tree



### Skewed Binary Tree

A **Skewed Binary Tree** is a type of Binary Tree where all nodes are shifted to either the **left** or **right** side. It can also be defined as a Binary Tree in which the number of children is firmly restricted to one at each node.

### Types of Skewed Binary Tree

There are two types of Skewed Binary Trees based on which side is dominated:

- ***Left-Skewed Binary Tree***
- ***Right-Skewed Binary Tree***

> ### Note[#](https://www.educative.io/module/page/Z4JLg2tDQPVv6QjgO/10370001/6546848606322688/5682634698260480#Note)
>
> Try your best to avoid such tree structures, especially in the case of a Binary Search Tree, as it will kill efficient searching (the core purpose of a Binary Search Tree).



## Binary Search Tree

A Binary Search Tree, also known as an ordered Binary Tree, is a variant of a Binary Tree with a **strict condition** based on `node` value.

For all the nodes in a BST, the values of all the nodes in the left sub-tree of the current node are less than or equal to the value of the node itself. All the node values in the right subtree are greater than the value of the current node. This is referred to as the BST rule.
$$
NodeValues(LeftSubtree)<=CurrentNodeValue<NodeValues(RightSubTree)
$$


###  Deletion in Binary Search Trees

- Deletion at Leaf Node: Search and delete
- Deletion at Parent Node
  - Node has only **one** child: Search and delete, take the *deleted* parent-node’s child and link it with the parent node of the *deleted* node.
  - Node has **two** children: 
    1. Start by traversing the **right subtree** of the soon-to-be deleted parent node in such a way that you reach the **left-most** value—the value that will appear to be the **smallest** value in the whole subtree.
    2. Replace the value of the *node*, found in the last step, with the *parent’s* node value.
    3. Finally, **delete** the leaf node.



## AVL Tree

**AVL** trees are a self-balanced special type of Binary Search Tree with just **one** exception:

*For each Node, the maximum height difference between the left and right sub-trees can only be one.*



### Time Complexity

In the case of BST, the **Big(O)** of all three basic operations (*Insertion*, *Deletion*, and *Searching*) takes **O(h)** time, where *“h”* is the **height** of a Binary Search Tree.

In the case of *Skewed Trees*, the complexity becomes **O(n)**, where *“n”* is the number of nodes in the tree. Now to improve time complexity, We have to manage the height of the tree to improve time complexity, such that we can bring the time down to **O(logn)** for performing these basic operations.



### When to use AVL Trees?

As *AVL* are strictly balanced, **AVL** Trees are preferred in those applications where the *lookup* is the  most *vital*



## AVL Insertion

*Insertion* for an AVL tree follows the same steps that we covered in BST *insertion*.

*The **main** step comes after insertion when the tree gets unbalanced*.

To *re-balance* the tree, we need to perform some kind of rotation (*left* or *right*).

 some of the *terms* which we will be using while re-balancing the tree.

- **Node U** – an *unbalanced* node
- **Node C** – *child* node of **node U**
- **Node G** – *grandchild* node of **node U**



### Types of rotations

To rebalance the tree, we will perform *rotations* on the subtree with **Node U** as being the **root** node.

There are **two** types of rotations:

- left
- right



### Insertion Cases

We came across *four* different scenarios based on the arrangements of **Nodes U, C** and, **G**.

- **Left-Left:** Node **C** is the *left-child* of Node **U**, and Node **G** is the *left-child* of Node **C**.
- **Left-Right:** Node **C** is the *left-child* of Node **U**, and Node **G** is the *right-child* of Node **C**.
- **Right-Right:** Node **C** is the *right-child* of Node **U**, and Node **G** is the *right-child* of Node **C**.
- **Right-Left:** Node **C** is the *right-child* of Node **U**, and Node **G** is the *left-child* of Node **C**.



#### Case 1: Left-Left

In the **left-left** case, we only need to make a *single* rotation towards the **right** at **Node U** to balance the **AVL** tree. 

#### Case 2: Left-Right

In the **left-right** case we need to make *two* rotations:

- First is a *left* rotation at Node **C**.
- Second is a *right* rotation at Node **U**.

These two rotations balance the **AVL** tree. In this case, Node **G** becomes the *parent* node of both Node **C** and **U**.

#### Case 3: Right-Right

The **right-right** case is just like the *left-left* case. The only difference is that instead of rotating *right*, we need to make a *single* rotation towards the **left** at Node **U** to balance the **AVL** tree. In the final balanced version, **Node C** becomes the *parent* node of Node **G** and **U** and its *two* subtrees become balanced.

#### Case 4: Right-Left

The **right-left** case is similar to the *left-right* case. The only difference is that the two rotations performed are as follows:

- First is a *right* rotation at Node **C**.
- Second is a *left* rotation at Node **U**.

These two rotations balance the **AVL** tree. In this case, Node **G** becomes the *parent* node of both Node **C** and **U**.



### Time Complexity

Considering that it takes constant time to do *left-right* rotation operations and update the height to get a balanced tree, the time complexity of an **AVL** insert remains the same as BST insert: **O(h)** where **h** is the height of the tree. However, since the **AVL** tree is balanced, the height is **O(logn)**; so the time complexity of an AVL insert is **O(logn)**



## AVL Deletion

*Deletion* is similar to **AVL’s** *insertion* operation with just **one** exception:

*The deletion operation adds an extra step after the insertion method’s rotation and balancing of the first unbalanced node.*

After fixing the **first** *unbalanced* node through rotations, start moving **up** and fix the next *unbalanced* node. Keep on fixing the *unbalanced* nodes until you reach the **root**.

### Steps for Deletion

The following are the detailed steps for *removing* value from **AVL Trees**.

#### Step 1: Delete currentNode

Delete the *currentNode* in the same way as we did in **BST** *deletion*. At this point, the tree will become *unbalanced*, and we would need to perform some kind of *rotation* (**left** or **right**) to *rebalance* the tree.

#### Step 2: Traverse Upwards[#](https://www.educative.io/module/page/Z4JLg2tDQPVv6QjgO/10370001/6546848606322688/5236379543142400#Step-2:-Traverse-Upwards)

Start traversing from *currentNode* upwards till you find the **first** *unbalanced* node.

- **Node U** — an **unbalanced** node
- **Node C** — **child** node of node **U**
- **Node G** — **grandchild** node of node **U**

#### Step 3: Rebalance the Tree

To *rebalance* the tree, we will perform rotations on the *subtree* where **U** is the *root* node.

There are **two** types of rotations:

- left
- right

We came across **four** different scenarios based on the arrangements of Nodes **U**, **C** and, **G**.

- **Left-Left:** Node **C** is the *left-child* of Node **U**, and Node **G** is the *left-child* of Node **C**.
- **Left-Right:** Node **C** is the *left-child* of Node **U**, and Node **G** is the *right-child* of Node **C**.
- **Right-Right:** Node **C** is the *right-child* of Node **U**, and Node **G** is the *right-child* of Node **C**.
- **Right-Left:** Node **C** is the *right-child* of Node **U**, and Node **G** is the *left-child* of Node **C**.

After performing a successful rotation for the **first** *unbalanced* Node **U**, traverse up and find the next *unbalanced* node and perform the same series of operations to *balance*. Keep on balancing the *unbalanced* nodes from **first** Node **U** to *ancestors* of Node **U** until we reach the **root**. After that point, we will have a **fully** balanced **AVL Tree**



## Red-Black Tree

**A Red-Black Tree** is another type of self-balancing Binary Search Tree, just like the *AVL Trees* , but with some *additions*. The nodes in a **Red-Black Tree** are colored to either **red** or **black**. *Colored* nodes help in re-balancing the tree after *insertion* or *deletion*. 

### Properties of Red-Black Trees

- Every node has either **Red** or **Black** color.
- The root is always colored **black**.
- Two **red** nodes cannot be *adjacent*, i.e. **no** *red* parent can have a *red* child and vice versa.
- Every path from the *root* to a *leaf* must contain the exact same number of **black-colored** nodes.
- Every *null* node is considered to be **black** in color.

### Time Complexity

Balancing the tree doesn’t result in a tree being perfectly balanced, but it is good enough to get the time complexity close to O(logn) for basic operations like *searching*, *deletion*, and *insertion*.

### AVL vs Red-Black Trees

Although *AVL Trees* are more balanced than **Red-Black Trees**, *AVL Trees* take **more** rotations during *insertion* and *deletion* operations than **Red-Black** Trees. So, if you have a search-intensive application where *insertion* and *deletion* are not that frequent, then use *AVL Trees*. Otherwise, use **Red-Black** Trees for those applications involving more *insertions* and *deletions*.



## Red-Black Tree Insertion

The following are the steps involved in *inserting* value into a Red-Black Tree:

1. Insert *currentNode* using the standard BST insertion technique that we studied earlier, and make currentNode **red**.
2. If *currentNode* is the root, then change the color of *currentNode* to **black**.
3. If *currentNode* is not the *root*, then we will have to perform some operations to make the tree follow the **Red-Black** property.



### Rebalancing the Tree

To balance an *unbalanced* tree, we have **two** techniques which are used depending on some conditions that we will discuss shortly. The **two** techniques are:

1. **Recoloring Nodes**.
2. **Rotating Nodes (left or right)**.



*First*, we need to *define* the structure of the Red-Black Tree and some nodes relative to the *currentNode*, which is the node that we inserted in the Red-Black Tree.

- Node C – newly inserted node (*currentNode*)
- Node P – parent of *currentNode*
- Node G – grandparent of *currentNode*
- Node U – uncle of *currentNode* / sibling of Node P / child of Node G

If *currentNode* is not a root, and the parent of *currentNode* is not **black**, first, we will check Node U (the *uncle* of *currentNode*). Based on Node U’s color, we will perform some steps to make the tree balanced. If Node U is **red**, then do the following:

1. Change the color of Node P and U to black
2. Change the color of Node G to red
3. Make Node G the *currentNode* and repeat the same process from step two

If Node U (*uncle*) is **black**, then we come across four different scenarios based on the arrangements of Node P and G, just like we did in AVL trees. We will cover each of these scenarios

- Left-Left: Node P is the *leftChild* of Node G, and *currentNode* is the *leftChild* of Node P
- Left-Right: Node P is the *leftChild* of Node G, and *currentNode* is the *rightChild* of Node P
- Right-Right: Node P is the *rightChild* of Node G, and *currentNode* is the *rightChild* of Node P
- Right-Left: Node P is the *rightChild* of Node G, and *currentNode* is the *leftChild* of Node P



- Assume Current C Red, insert like BST, if it is root, change it to Black.
- Check parent P
  - If it is Black, just add after P
  - If P is Red, Check the Uncle U
    - If U is red, Change P and U to be Black, and grandfather P to be the Current C and Red. And repeat the same process.
    - If U is black, we would perform some rotation base on scenarios:
      - Left-Left: 
        1. Rotate Node G towards the Right
        2. Swap the colors of Nodes G and P
      - Left-Right: Node P is the *leftChild* of Node G, and *currentNode* is the *rightChild* of Node P
      - Right-Right: Node P is the *rightChild* of Node G, and *currentNode* is the *rightChild* of Node P
      - Right-Left: Node P is the *rightChild* of Node G, and *currentNode* is the *leftChild* of Node P
    - e
  - If It is 







## Conclusion

### Binary Trees

**Definition:** A tree having a max. of two children at each internal node

**Types:** Perfect, Full, Complete, Skewed

**Total number of leaf nodes:** 
$$
2^h or \frac{n + 1}{2}
$$
**Height:** 
$$
log_2(n+1) -1
$$
**Height:** 
$$
O(log_2n)
$$
```mermaid
graph TD 
	A((1)) -->B((2))
	A -->C((3))
	
	B -->D((4))
	B -->E((5))
	

```

### Binary Search Trees

**Definition:** Every node has a value greater than/equal to all the node values in its left sub-tree, and has a value less than all the node values in its right sub-tree. Mathematically,
$$
Keys(SubTree1)<Keys(Y)<Keys(Subtree2)<Keys(X)<Keys(SubTree3)
$$

```mermaid
graph TD 
	A(Node X) -->B(Node Y)
	A -->C(SubTree 3)
	
	B -->D(SubTree 1)
	B -->E(Sub Tree 2)
	
```

### Red Black Trees

**Definition:**  A tree where every node is colored as red or black, no two adjacent nodes have *red* coloring, and root and null nodes are considered *black*.

**Height:** 
$$
h<=2log_2 (n+1)
$$
**Minimum number of nodes:**
$$
N(h)=1+N(h-1)+N(h-2)
$$

```mermaid
graph TD 
	A((6)) -->B((4))
	A -->C((8))
	
	B -->D((3))
	B -->E((5))
	
	C -->F((7))
	C -->G(( _ ))
	
	D -->H((2))
	D -->I((_))

```



### AVL Trees

**Definition:** For each node, the height of the left and right *sub-trees* differ by a max. of one.

**Height:** 
$$
h<=2log _2(n+1)
$$

**Minimum number of nodes:**
$$
(ℎ+1)+2\sum_{i=0}^{y}2^i - 1, \quad where \quad y\quad is \quad equal \quad to: \bf{floor(h/2)}
$$





```mermaid
graph TD 
	A(6_Black) -->B(3-Black)
	A -->C(12_Red)
	
	C -->D(10_Black)
	C -->E(14_Black)
	
	D -->F(8_Red)
	D -->G(11_Red)
	
	E -->H(Null_BLack)
	E -->I(20_Red)

```



### 2-3 trees

**Definition:** A balanced and ordered tree where each node can have a max. of two keys (X and Y) and three children, such that,
$$
LChild.Key < X < MChild.Key < Y < RChild.Key
$$
**Maximum number of nodes:** 
$$
3^h
$$
**Height:** 
$$
log_4(n+1)−1<h<log_2(n+1)−1
$$
**Types:** *2-3-4 Trees*

```mermaid
graph TD 
	A(50 90) -->B(20)
	A -->C(70)
	A -->D(120 150)
	
	B -->E(10)
	B -->F(30 45)
	
	C -->G(60)
	C -->H(80)
	
	D -->I(100 110)
	D -->J(130 140)
	D -->K(200)
```