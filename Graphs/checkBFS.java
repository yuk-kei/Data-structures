package Graphs;

import LinkedLists.DoublyLinkedList;
import Queue.Queue;

public class checkBFS {
    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        StringBuilder result = new StringBuilder();

        if(g.vertices < 1){
            return result.toString();
        }

        boolean[] visited = new boolean[g.vertices];
        for(int i = 0; i< g.vertices; i++ ){
            if(!visited[i]){
                result.append(bfs(g, i, visited));
            }
        }

        return result.toString();
    }

    private static String bfs(Graph g, int i, boolean[] visited) {
        Queue<Integer> q = new Queue<Integer>(g.vertices);
        StringBuilder result = new StringBuilder();
        q.enqueue(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int current = q.dequeue();
            result.append(String.valueOf(current));

            DoublyLinkedList<Integer>.Node tmp = null;
            if(g.adjacencyList[current] != null){
                tmp = g.adjacencyList[current].headNode;
            }
            while(tmp != null){
                if(!visited[tmp.data]){
                    q.enqueue(tmp.data);
                    visited[tmp.data] = true;

                }
                tmp =tmp.nextNode;
            }
        }
        return result.toString();
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
