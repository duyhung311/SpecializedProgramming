package block3.MatchNumbersEasy;//package block3.MatchNumbersEasy;

import java.util.*;

public class MatchNumbersEasy {
    public String maxNumber(int[] matches, int n) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = matches.length - 1; i >= 0; i--) {
            map.put(i, matches[i]);
        }

        Integer max = Integer.MIN_VALUE;
        List<Long> genNumber = new LinkedList<>();
        makeNumbers(map, n, max, "", genNumber);
        Long max1 = genNumber.stream()
                .max(Long::compareTo)
                .orElse(0L);
        return String.valueOf(max1);


    }

    private void makeNumbers(Map<Integer, Integer> resources, int n, long max, String currentNum, List<Long> genNumber) {

        for (Map.Entry<Integer, Integer> entry : resources.entrySet()) {
            StringBuilder numBuilder = new StringBuilder(currentNum);
            int number = entry.getKey();
            int matchToMakeNumber = entry.getValue();
            if (n - matchToMakeNumber >= 0) {
                numBuilder.append(number); // may check for 0 and terminate here
                max = Long.parseLong(numBuilder.toString());
                genNumber.add(max);
                makeNumbers(resources, n - matchToMakeNumber, max, numBuilder.toString(), genNumber);
            }
        }


    }

    public static void main(String[] args) {
        MatchNumbersEasy matchNumbersEasy = new MatchNumbersEasy();
        int[] matches = {1,1,1,1,1,1,1,1,1,1};
        int n = 50;
        System.out.println(matchNumbersEasy.maxNumber(matches, n).equals("99999999999999999999999999999999999999999999999999"));
    }
}
