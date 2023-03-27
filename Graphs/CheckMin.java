package Graphs;

import LinkedLists.DoublyLinkedList;
import Queue.Queue;


public class CheckMin {
    public static int findShortestPathDFS(Graph g, int source, int destination) {
        boolean[] visited = new boolean[g.vertices];
        int currMin = Integer.MAX_VALUE;

        return findShortestPathDFS(g, source, destination, visited, currMin,0);
    }

    private static int findShortestPathDFS(Graph g, int curr, int dest, boolean[] visited, int currMin, int len){
        if(curr == dest){
            return Math.min(currMin,len);
        }

        if(visited[curr]){
            return currMin;
        }
        visited[curr] = true;
        len ++;
        DoublyLinkedList<Integer>.Node head = null;
        if(!g.adjacencyList[curr].isEmpty()){
            head = g.adjacencyList[curr].getHeadNode();
        }

        while(head != null){
            currMin = findShortestPathDFS(g, head.data, dest, visited, currMin,len);
            head = head.nextNode;
        }
        return currMin == Integer.MAX_VALUE ? -1:currMin;
    }

    public static int findShortestPathBFS(Graph g, int source, int destination){
        if (source == destination){
            return 0;
        }

        int result = 0;
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you enqueue it into queue
        boolean[] visited = new boolean[num_of_vertices];

        //For keeping track of distance of current_node from source
        int[] distance = new int[num_of_vertices];

        //Create Queue for Breadth First Traversal and enqueue source in it
        Queue<Integer> queue = new Queue<Integer>(num_of_vertices);

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {

            //Dequeue a vertex/node from queue and add it to result
            int current_node = queue.dequeue();

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then enqueue them in the Queue
            //and also update their distance from source by adding 1 in current_nodes's distance
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[current_node] + 1;
                }
                if (temp.data == destination) {
                    return distance[destination];
                }
                temp = temp.nextNode;
            }
        }
        return -1;
    }


    public static void main(String args[]) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(findShortestPathDFS(g, 0, 4));
        System.out.println(findShortestPathBFS(g, 0, 4));

    }
}
