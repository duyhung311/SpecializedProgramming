import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Inchworm {
    public int lunchtime(int branch, int rest, int leave) {
        int cnt = 1;
        for (int i = rest; i <= branch; i += rest) {
            if (i % leave == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public void run() {

        Integer[][] inputs = {{11, 2, 4}, {12, 6, 4}, {20, 3, 7}, {21, 7, 3}, {15, 16, 5}, {1000, 3, 7}, {1000, 7, 3}};
        Map<List<Integer>, Integer> testCases = new HashMap<>();
//        testCases.put(Arrays.asList(inputs[0]), 3);
//        testCases.put(Arrays.asList(inputs[1]), 2);
//        testCases.put(Arrays.asList(inputs[2]), 1);
//        testCases.put(Arrays.asList(inputs[3]), 2);
//        testCases.put(Arrays.asList(inputs[4]), 1);
        testCases.put(Arrays.asList(inputs[5]), 48);
//        testCases.put(Arrays.asList(inputs[6]), 48);
        for (Map.Entry<List<Integer>, Integer> testCase : testCases.entrySet()) {
            int res = lunchtime(testCase.getKey().get(0), testCase.getKey().get(1), testCase.getKey().get(2));
            if (!testCase.getValue().equals(res)) {
                throw new RuntimeException("Error: " + testCase.getKey() + " with res = " + res);
            }
        }
        System.out.println("Testcases all passed");

    }

}