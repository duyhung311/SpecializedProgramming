//package pexam1.NiceBoxes.GardenNoise;

import java.util.*;

public class GardenNoise {


    public int countDucks1(String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int currentDuck = 0;
        List<int[]> completeDuck = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'q') {
                List<Integer> d = new ArrayList<>();
                d.add(i);
                map.put(currentDuck++, d);
            } else if (s.charAt(i) == 'k') {
                Optional<Integer> firstDOp = map.keySet().stream().sorted().findFirst();
                if (firstDOp.isEmpty())
                    continue;
                int firstD = firstDOp.get();
                int[] completeD = {map.get(firstD).get(0), i};
                completeDuck.add(completeD);
                map.remove(firstD);
            }
        }
        int cnt = completeDuck.size();
        for (int i = 0; i < completeDuck.size(); i++) {
//            if (i ==0)
//                cnt = 1;
            int end = completeDuck.get(i)[1];
            boolean breakFlag = false;
            for (int j = i + 1; j < completeDuck.size(); j++) {
                int start = completeDuck.get(j)[0];
                if (end > start) {
                    cnt--;
                    breakFlag = true;
                }
                if (breakFlag) {
                    break;
                }
            }
        }
        return cnt;
//        if (cnt == 1 || cnt == -1)
//            return cnt;
//        return cnt -1;
    }

    public int countDucks(String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int currentDuck = 0;
        List<int[]> completeDuck = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'q') {
                List<Integer> d = new ArrayList<>();
                d.add(i);
                map.put(currentDuck++, d);
            } else if (s.charAt(i) == 'k') {
                Optional<Integer> firstDOp = map.keySet().stream().sorted().findFirst();
                if (firstDOp.isEmpty())
                    continue;
                int firstD = firstDOp.get();
                int[] completeD = {map.get(firstD).get(0), i};
                completeDuck.add(completeD);
                map.remove(firstD);
            }
        }

        int cnt = 0;
        for (int i = 0; i < completeDuck.size(); i++) {
            int end = completeDuck.get(i)[1];
            for (int j = i + 1; j < completeDuck.size(); j++) {
                int start = completeDuck.get(j)[0];
                if (end > start) {
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            return -1;
        }
        return cnt;

    }


    public static void main(String[] args) {

        GardenNoise gardenNoise = new GardenNoise();
        System.out.println(gardenNoise.countDucks("qqqquuuuaaaacccckkkk")); //3
        System.out.println(gardenNoise.countDucks("quqacukqauackck")); //2
        System.out.println(gardenNoise.countDucks("quackquackquack")); //1
        System.out.println(gardenNoise.countDucks("kcauq")); // -1
        System.out.println(gardenNoise.countDucks("qqqquuuuaaaaccccckkkk")); //4
        /**
         * 3
         * 2
         * 1
         * -1
         * 4
         */
    }
}
