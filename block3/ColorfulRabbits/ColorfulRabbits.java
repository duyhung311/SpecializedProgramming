package block3.ColorfulRabbits;

import java.util.HashMap;
import java.util.Map;

public class ColorfulRabbits {
    int getMinimum(int[] replies) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int reply : replies) {
            map.put(reply, map.getOrDefault(reply, 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= entry.getKey() + 1) { // base case
                cnt+= entry.getKey()+1;
            }
            if (entry.getValue() > entry.getKey() + 1) {
                int rabbitAns = entry.getKey();
                int numberOfAns = entry.getValue();
                int times = numberOfAns / (rabbitAns+1);
                int remainder = numberOfAns % (rabbitAns+1);
                cnt += times*(rabbitAns + 1);
                if (remainder > 0) {
                    cnt += rabbitAns+1;
                }
            }


        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] replies1 = { 1, 1, 2, 2 };
        int[] replies = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(new ColorfulRabbits().getMinimum(replies));
    }
}
