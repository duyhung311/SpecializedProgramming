package block5.FamilyTravel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyTravel {
   Map<String, List<String>> map = new HashMap<>();


//    private void buildTimeGraph(String[] edges) {
//        timeGraph= new int[edges.length][edges[0].length()];
//
//        for (int i = 0; i < edges.length; i++) {
//            String[] ele = edges[i].split("");
//            for (int j = 0; j < ele.length; j++) {
//                if (ele[j].equals("0")) {
//                    timeGraph[i][j] = 0;
//
//                } else if (Character.isLowerCase(ele[j].charAt(0))) { //a-z
//                    timeGraph[i][j] = ele[j].charAt(0) - 'a' + 1;
//                } else {
//                    timeGraph[i][j] = ele[j].charAt(0) - 'A' + 1;
//                }
//
//            }
//        }
//        findPath(timeGraph);
//    }
//    private void buildGraph() {
//        MyGraph<Integer,Integer> graph = new MyGraph<>();
//        for (int i = 0; i < timeGraph.length; i++) {
//            for (int j = 0; j < timeGraph[i].length; j++) {
//                graph.addEdge(i, j, timeGraph[i][j]);
//            }
//        }
//
//        //findPath(graph);
//    }

    private void findPath(int[][] g) {
//        List<MyGraph.Edge<Integer>> startEdge =
//                graph.graph.keySet()
//                        .stream()
//                        .filter(x -> x.from == 0)
//                        .toList();
        boolean[] visited = new boolean[g[0].length];
        int start = 0;
        visited[start] = true;
        int min = Integer.MAX_VALUE;
        // dijkstra algo
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else if (!visited[i]) {
                    g[i][j] =
                    min = Math.min(min, g[i][j]);
                }
            }
        }



    }


    public int shortest(String[] edges) {
        return 0;

    }
    public static void main(String[] args) {
//        String[] input = {"0Zej0","Z0fkh","ef00d","jk00i","0hdi0"};
//        new FamilyTravel().buildTimeGraph(input);
    }
}
