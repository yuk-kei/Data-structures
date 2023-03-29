package graphs;

import linkedLists.DoublyLinkedList;

public class CheckCycle {
    public static boolean detectCycle(Graph g){
        int n = g.vertices;
        int[] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(g,i,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(Graph g, int node, int[] visited){
        if(visited[node] > 1){
            return true;
        }
        DoublyLinkedList<Integer>.Node curr = null;
        if (g.adjacencyList[node] != null)
             curr = g.adjacencyList[node].headNode;


        visited[node] ++;
        while(curr != null){
            if(dfs(g, curr.data,visited)){
                return true;
            }

            curr = curr.nextNode;
        }
        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}
