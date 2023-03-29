package trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckKNodes {
    public static String findKNodesBFS(Node root, int k) {

        Queue<Node> q = new LinkedList<>();
        StringBuffer res = new StringBuffer();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            Node curr;
            for(int i = 0; i < sz; i++){
                curr = q.poll();
                if(curr != null){

                    q.offer(curr.leftChild);
                    q.offer(curr.rightChild);
                }
            }

            if(++level == k){
                while(!q.isEmpty()){
                    Node tmp = q.poll();
                    if(tmp != null){

                        res.append(tmp.getData() + ",");
                    }

                }
                return res.toString();
            }
        }


        return "Can not find!!!";
    }

    public static String findKNodesDFS(Node root, int k) {

        StringBuilder result = new StringBuilder(); //StringBuilder is immutable
        findK(root, k, result);

        return result.toString();
    }


    public static void findK(Node root, int k, StringBuilder result) {

        if (root == null) return;

        if (k == 0) {
            result.append(root.getData() + ",");
        }
        else {
            //Decrement k at each step till you reach at the leaf node
            // or when k == 0 then append the Node's data into result string
            findK(root.getLeftChild(), k - 1, result);
            findK(root.getRightChild(), k - 1, result);
        }
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();


        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println(findKNodesBFS(bsT.getRoot(), 2));
        System.out.println(findKNodesDFS(bsT.getRoot(), 2));
    }
}
