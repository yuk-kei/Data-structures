package trees;

public class CheckAncestors {
    static String res;
    public static String findAncestors(Node root, int k) {
        StringBuffer curr = new StringBuffer();
        traverse(root, k, curr);
        return res;
    }

    private static void traverse(Node root, int k, StringBuffer curr) {
        if(root == null){
            return;
        }

        if(root.getData() == k){
            res = curr.toString();
        }

        curr.append(root.getData() + ",");

        traverse(root.leftChild, k, curr);
        traverse(root.rightChild, k, curr);
        curr.deleteCharAt(curr.length() - 1);
        curr.deleteCharAt(curr.length() - 1);
    }

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));
    }
}
