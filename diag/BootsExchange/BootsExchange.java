package diag.BootsExchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BootsExchange {
    public int leastAmount(int[] left, int[] right) {
        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        for (int i =0; i < left.length; i++) {
            int el = left[i];
            
            leftMap.computeIfAbsent(el, k -> new ArrayList<>());
            leftMap.computeIfPresent(el, (k, v) -> {
                v.add(el);
                return v;
            });

            int rh = right[i];
            rightMap.computeIfAbsent(rh, k -> new ArrayList<>());
            rightMap.computeIfPresent(rh, (k, v) -> {
                v.add(rh);
                return v;
            });
            
        }
        System.out.println(1);
        return 1
    ;
    }
}
