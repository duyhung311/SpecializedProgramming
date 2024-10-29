package block4.CellRemoval;

import java.util.*;

public class CellRemoval {
    public static int cellsLeft(int[] parent, int deletedCell) {
        Map<Integer, Vector<Integer>> tree = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                continue;
            }
            if (!tree.containsKey(parent[i])) {
                tree.put(parent[i], new Vector<Integer>());
            }
            tree.get(parent[i]).add(i);
            if (!tree.containsKey(i)) {
                tree.put(i, new Vector<Integer>());
            }
        }

        tree = deleteNode(tree, deletedCell);

        int result = 0;
        for (Vector<Integer> children : tree.values()) {
            if (children.size() == 0) {
                result++;
            }
        }
        return result;
    }

    public static Map<Integer, Vector<Integer>> deleteNode(Map<Integer, Vector<Integer>> tree, int deletedCell) {
        if (tree.containsKey(deletedCell)) {
            for(int i = 0; i < tree.get(deletedCell).size(); i++){
                tree = deleteNode(tree, tree.get(deletedCell).get(i));
            }
            tree.remove(deletedCell);
        }
        return tree;
    }


    public static void main(String[] args) {
        int[] parent = {-1,0,0,2,2,4,4,6,6};
        System.out.println(new CellRemoval().cellsLeft(parent, 4));
    }
}
