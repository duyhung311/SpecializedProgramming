package diag.BootsExchange;

import java.util.*;

public class BootsExchange {
    public int leastAmount(int[] left, int[] right) {
        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        int cnt = left.length;
        for (int i = 0; i < left.length; i++) {
            int le = left[i];
            leftMap.computeIfAbsent(le, k -> new ArrayList<>()).add(le);

            int ri = right[i];
            rightMap.computeIfAbsent(ri, k -> new ArrayList<>()).add(ri);
        }

         for (Map.Entry<Integer, List<Integer>> entry : leftMap.entrySet()) {
            int key = entry.getKey();
            if (rightMap.containsKey(key)) {
                int mappedPair = Math.min(entry.getValue().size(), rightMap.get(key).size());
                cnt -= mappedPair;
            }
        }
        return cnt;
    }
}
