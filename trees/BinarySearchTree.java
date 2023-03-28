package trees;

public class BinarySearchTree {

    //Variables
    private Node root;
    //Getter for Root

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    //Searches value in BST
    //Either returns the Node with that value or return null
    public Node search(int value) {

        if (isEmpty()) return null;

        Node currentNode = this.root;

        while (currentNode != null) {

            if (currentNode.getData() == value) return currentNode;

            if (currentNode.getData() > value) currentNode = currentNode.getLeftChild();
            else currentNode = currentNode.getRightChild();
        }

        System.out.println(value + " is not in Tree !");
        return null;
    }
    //Recursive function to insert a value in BST
    public Node recursive_insert(Node currentNode, int value) {

        //Base Case
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            //Iterate left subtree
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right subtree
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;

    }

    //Function to call recursive insert
    public boolean add(int value) {

        root = recursive_insert(this.root, value);
        return true;
    }


    //Function to check if Tree is empty or not

    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(Node current) {

        if (current == null) return;

        System.out.print(current.getData());
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }
}
