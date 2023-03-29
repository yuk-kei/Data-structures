package graphs;


import linkedLists.DoublyLinkedList;

public class CheckTree {
    public static boolean isTree(Graph g) {
        int n = g.vertices;;
        boolean[] visited = new boolean[n];

        if(detectCycle(g, 0, visited)){
            return false;
        }

        for(int i = 0; i< visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean detectCycle(Graph g, int node, boolean[] visited) {
        if(visited[node]){
            return true;
        }
        visited[node] = true;
        DoublyLinkedList<Integer>.Node head = null;
        if(!g.adjacencyList[node].isEmpty()){
            head = g.adjacencyList[node].headNode;
        }

        while(head != null){
            if(detectCycle(g, head.data, visited)){
                return true;
            }
            head = head.nextNode;
        }

        return false;
    }

    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(0,3);
        g2.addEdge(3,2);
        g2.printGraph();
        System.out.println("isTree : " + isTree(g2));

        Graph g3 = new Graph(6);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(0,3);
        g3.addEdge(4,5);
        g3.printGraph();
        System.out.println("isTree : " + isTree(g3));
    }
}
