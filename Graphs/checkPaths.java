package Graphs;

import LinkedLists.DoublyLinkedList;

public class checkPaths {
    public static boolean checkPath(Graph g, int source, int destination) {

        boolean[] visited = new boolean[g.vertices];

        return checkPath(g, source, destination, visited);
    }

    private static boolean checkPath(Graph g, int curr, int dest, boolean[] visited){
        if(visited[curr]){
            return false;
        }
        if(curr == dest){
            return true;
        }
        visited[curr] = true;
        DoublyLinkedList<Integer>.Node head = null;
        if(!g.adjacencyList[curr].isEmpty()){
            head = g.adjacencyList[curr].getHeadNode();
        }

        while(head != null){
            if(checkPath(g, head.data, dest, visited)){
                return true;
            }
            head = head.nextNode;
        }

        return  false;
    }

    public static void main(String args[]) {

        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }
}
