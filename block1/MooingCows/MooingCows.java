
import java.util.*;

public class MooingCows {

    public int dissatisfaction(String[] farmland) {
        List<List<Integer>> farmlandCount = getCowLocations(farmland);
        int min = Integer.MAX_VALUE;
        for (List<Integer> entry : farmlandCount) {
            int key = entry.get(0);
            int value = entry.get(1);


            int sum = 0;
//            for (Map.Entry<Integer, Integer> newEntry : farmlandCount.entrySet()) {
            for (List<Integer> newEntry : farmlandCount) {
                sum += calDissatisfaction(key, value, newEntry.get(0), newEntry.get(1));
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static List<List<Integer>> getCowLocations(String[] farmland) {
        List<List<Integer>> farmlandCount = new LinkedList<>();
        //collecting cows
        for (int i = 0; i < farmland.length; i++) {
            String[] cows = farmland[i].split("");
            for (int j = 0; j < cows.length; j++) {
                if (cows[j].equals("C")) {
                    List<Integer> cowLocation = new ArrayList<>();
                    cowLocation.add(i);
                    cowLocation.add(j);
                    farmlandCount.add(cowLocation);
                }
            }
        }
        return farmlandCount;
    }


    int calDissatisfaction(int cowX, int cowY, int i, int j) {
        return (int)  Math.sqrt(calDistance(cowX, cowY, i, j));
    }

     int calDistance(int cowX, int cowY, int i, int j) {
        int i1 = (int) (Math.pow(cowX - i,  2L) + Math.pow(cowY - j  , 2L));
        return i1 * i1;
    }
//
//    public static void main(String[] args) {
//        int res1 = calDissatisfaction(0,0,1,1) + calDissatisfaction(0,0, 2,1);
//        int res2 = calDissatisfaction(1,1,0,0) + calDissatisfaction(1,1, 2,1);
//        int res3 = calDissatisfaction(2,1,0,0) + calDissatisfaction(2,1, 1,1);
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
//    }


}

