package trees;

public class CheckHeight {
    public static int findHeight(Node root) {

        // Write - Your - Code
        return traverse(root);
    }

    private static int traverse(Node root){
        if(root == null){
            return -1;
        }

        int left = traverse(root.leftChild);
        int right = traverse(root.rightChild);
        return Math.max(left, right) + 1;
    }
}
