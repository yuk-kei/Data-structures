package Graphs;

import LinkedLists.DoublyLinkedList;

import java.util.Arrays;

public class CheckMotherVertex {
    public static int findMotherVertex(Graph g){

        int n = g.vertices;
        boolean[] visited = new boolean[n];
        int res = -1;

        for(int node = 0; node < n; node ++){
            if(!visited[node]){
                dfs(g, node, visited);
                res = node; //get the last node
            }
        }

        Arrays.fill(visited,false);
        dfs(g,res,visited);
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return -1;
            }
        }

        return res;
    }

    private static void dfs(Graph g, int node, boolean[] visited) {
        if(visited[node]){
            return;
        }
        visited[node]  = true;
        DoublyLinkedList<Integer>.Node head = null;
        if(g.adjacencyList[node] != null){
            head = g.adjacencyList[node].getHeadNode();
        }

        while(head != null){
            dfs(g,head.data,visited);
            head = head.nextNode;
        }

    }

    public static void main(String args[]) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));

    }

}
