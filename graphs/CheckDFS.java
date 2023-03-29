package graphs;

import linkedLists.DoublyLinkedList;

class CheckDFS {
    //Depth First Traversal of Graph g
    public static String dfs(Graph g) {
        StringBuilder result = new StringBuilder();

        if(g.vertices < 1){
            return result.toString();
        }

        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++){
            if(!visited[i]){
                result.append(dfs(g, i, visited));
            }
        }
        return result.toString();
    }

    private static String dfs(Graph g, int node, boolean[] visited) {

        StringBuilder result = new StringBuilder();

        if(visited[node]){
            return result.toString();
        }
        result.append(node);
        visited[node] = true;
        DoublyLinkedList<Integer>.Node temp = g.adjacencyList[node].headNode;

        while(temp != null){
            result.append(dfs(g, temp.data, visited));
            temp = temp.nextNode;
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
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}