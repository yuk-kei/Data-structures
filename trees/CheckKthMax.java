package trees;

public class CheckKthMax {
    private static int res = 0;
    private static int count = 0;

    public static int findKthMax(Node root, int k) {

        traverse(root, k);
        return  res;
    }

    private static void traverse(Node root, int target){
        if(root == null){
            return;
        }

        traverse(root.rightChild, target);
        count ++;
        if(count == target){
            res = root.getData();
        }

        traverse(root.leftChild, target);

    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(findKthMax(bsT.getRoot(),3));
    }

}
