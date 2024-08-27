
import java.util.*;

public class AlternateColors {
    private static final String RED = "RED";
    private static final String GREEN = "GREEN";
    private static final String BLUE = "BLUE";

    public String getColor(long r, long g, long b, long k) {

        Map<String, Long> colorMap =  new LinkedHashMap<>();
        List<String> colorsString = new LinkedList<>();

        colorsString.add(RED);
        colorsString.add(GREEN);
        colorsString.add(BLUE);

        colorMap.put(RED, r);
        colorMap.put(GREEN, g);
        colorMap.put(BLUE, b);

        String currentColor = RED;
        while (colorMap.size() > 1 && k > 0) {
            boolean clearFromThreeToZero = false;
            long divideBy = 0;
            Long re = colorMap.get(RED);
            Long gr = colorMap.get(GREEN);
            Long bl = colorMap.get(BLUE);
            if (re != null && re > 0) {
                divideBy++;
            }
            if (bl != null && bl > 0) {
                divideBy++;
            }
            if (gr !=null && gr > 0) {
                divideBy++;
            }
            long min = findMin(colorMap);
            long round = k / divideBy;
            long remainder = k % divideBy;
            if (round == 0) {
//                round = 1;
//                k = 0;
                return getTheNth(colorMap, (int) k);
            } else {
                if ( min < round ) {
                    round = min;
                }
                long tempK = k;
                k -= (round * divideBy);
                if (k == 0 && tempK % divideBy == 0) {
                    return getTheNth(colorMap, (int) divideBy);
                }
            }
            updateBallNumber(colorMap, round);
            if (k == 0) {
                if (Objects.equals(re, bl) && Objects.equals(gr, bl)) {
                    return BLUE;
                }

                long indexColor = (round-1)%divideBy;
                currentColor = colorsString.get((int) indexColor);

            }

            List<String> existingColor = new ArrayList<>(colorMap.keySet());
            colorsString.removeIf(x -> !existingColor.contains(x));

        }
        if (colorMap.size()==1) {
            return colorMap.keySet().iterator().next();
        }
        return currentColor;
    }

    private long findMin(Map<String, Long> balls) {
        if (balls.isEmpty())
            throw new IllegalArgumentException();
        long min = balls.entrySet().stream().findFirst().get().getValue();
        for (Map.Entry<String, Long> entry: balls.entrySet()) {
            min = Math.min(entry.getValue(), min);
        }
        return min;
    }
    private void updateBallNumber(Map<String, Long> balls, long min) {
        balls.replaceAll((k, v) -> v-min );
        balls.entrySet().removeIf(entry -> entry.getValue() == 0);
    }

    private String getTheNth(Map<String, Long> colorMap, int nth) {
        Iterator<String> iterator = colorMap.keySet().iterator();
        String res = null;
        for (int i = 0; i < nth; i++) {
            res = iterator.next();
        }
        return res;
    }

    public void run() {
        Long[][] inputs = {{1L,1L,1L,3L}, {3L,4L,5L,4L}, {7L,7L,1L,7L}, {1000000000000L,1L,1L,1000000000002L},
                {653L, 32L, 1230L,556L}, {39L,4L,29L,7L}, {35L,41L,37L,106L}, {29L, 48L, 24L, 94L},
                {32L,29L,25L, 30L},
                //stress test cases
                {17964018705L, 65273511246L, 31105494141L, 50314587302L}};
        Map<List<Long>, String> testCases = new LinkedHashMap<>();
//        testCases.put(Arrays.asList(inputs[0]), BLUE);
//        testCases.put(Arrays.asList(inputs[1]), RED);
//        testCases.put(Arrays.asList(inputs[2]), GREEN);
//        testCases.put(Arrays.asList(inputs[3]), RED);
//        testCases.put(Arrays.asList(inputs[4]), BLUE);
//        testCases.put(Arrays.asList(inputs[5]), RED);
//        testCases.put(Arrays.asList(inputs[6]), GREEN);
//        testCases.put(Arrays.asList(inputs[7]), GREEN);
//        testCases.put(Arrays.asList(inputs[8]), BLUE);
        //stress test case
        testCases.put(Arrays.asList(inputs[9]), GREEN);

        for (Map.Entry<List<Long>, String> testCase : testCases.entrySet()) {
            String res = getColor(
                    testCase.getKey().get(0),
                    testCase.getKey().get(1),
                    testCase.getKey().get(2),
                    testCase.getKey().get(3));
            //System.out.println(res);
            if (!testCase.getValue().equals(res)) {
                throw new RuntimeException("Error: " + testCase.getKey() + " with res = " + res + " but expected = " + testCase.getValue());
            }
        }
        System.out.println("Testcases all passed");
    }

}
