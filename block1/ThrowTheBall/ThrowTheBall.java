
import java.util.*;

public class ThrowTheBall {
    private static int numberOfPlayer;
    private static int step;
    public int timesThrown(int n, int m, int l) {
        numberOfPlayer = n;
        step = l;
        int[] times = new int[n + 1];
        int holdingPerson = 1;
        int cnt = 0;
        times[holdingPerson] += 1;
//        At the beginning of the game and before each next pass the following
//          actions are performed
        if (times[holdingPerson] >= m)
            return cnt;
        while (true) {
            if (times[holdingPerson] >= m)
                return cnt;
            cnt++;
            // throwing balls
            holdingPerson = nextPersonFrom(holdingPerson, times[holdingPerson]);
            times[holdingPerson]++;
        }
    }

    public int nextPersonFrom(int current, int timesHeld) {
        if (timesHeld % 2 == 0) {
            return passLeft(current);
        } else {
            return passRight(current);
        }
    }

    private int passLeft(int current) {
        return (current + (numberOfPlayer - step)) % numberOfPlayer;
    }
    private int passRight(int current) {
        return Math.abs(current + step) % numberOfPlayer;
    }

    public void run() {
        Integer[][] inputs = {{5,3,2}, {4,1,3}, {10,3,5}, {15,4,9}};
        Map<List<Integer>, Integer> testCases = new HashMap<>();
        testCases.put(Arrays.asList(inputs[0]), 10);
        testCases.put(Arrays.asList(inputs[1]), 0);
        testCases.put(Arrays.asList(inputs[2]), 4);
        testCases.put(Arrays.asList(inputs[3]), 15);

        for (Map.Entry<List<Integer>, Integer> testCase : testCases.entrySet()) {
            int res = timesThrown(testCase.getKey().get(0), testCase.getKey().get(1), testCase.getKey().get(2));
            if (!testCase.getValue().equals(res)) {
                throw new RuntimeException("Error: " + testCase.getKey() + " with res = " + res);
            }
        }


    }
}
