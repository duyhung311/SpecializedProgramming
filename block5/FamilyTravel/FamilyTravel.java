package block5.FamilyTravel;

public class FamilyTravel {
    int V = 9;

    int minDistance(int dist[], boolean visited[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance
    // array
    void printSolution(int dist[])
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source
    // shortest path algorithm for a graph represented using
    // adjacency matrix representation
    void dijkstra(int[][] graph, int src)
    {
        int dist[] = new int[V]; // The output array.
        // dist[i] will hold
        // the shortest distance from src to i

        // visited[i] will true if vertex i is included in
        // shortest path tree or shortest distance from src
        // to i is finalized
        boolean[] visited = new boolean[V];

        // Initialize all distances as INFINITE and stpSet[]
        // as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to src in first iteration.
            int u = minDistance(dist, visited);

            // Mark the picked vertex as processed
            visited[u] = true;

            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in visited,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!visited[v] &&  //chua visit
                        graph[u][v] != 0 && // co duong di tu u den v
                        dist[u] != Integer.MAX_VALUE && // chua tim ra shortest path,
                        // chi update khi co so finite
                        dist[u] + graph[u][v] < dist[v] && //
                        v - 1 >= 0 &&
                        graph[u][v-1] != 0 &&
                        graph[u][v-1] >= graph[u][v]
                ) {
                    dist[v] = dist[u] + graph[u][v];
                }
        }

        // print the constructed distance array
        printSolution(dist);
    }

    int shortest(String[] edges) {
        V = edges.length;
        int[][] timeGraph= new int[edges.length][edges[0].length()];
        for (int i = 0; i < edges.length; i++) {
            String[] ele = edges[i].split("");
            for (int j = 0; j < ele.length; j++) {
                if (ele[j].equals("0")) {
                    timeGraph[i][j] = 0;

                } else if (Character.isLowerCase(ele[j].charAt(0))) { //a-z
                    timeGraph[i][j] = ele[j].charAt(0) - 'a' + 1;
                } else {
                    timeGraph[i][j] = ele[j].charAt(0) - 'A' + 1;
                }

            }
        }

        dijkstra(timeGraph, 0);
        return 1;


    }
    public static void main(String[] args) {
        String[] input = {"0Zej0","Z0fkh","ef00d","jk00i","0hdi0"};
        new FamilyTravel().shortest(input);
    }
}
