//package pexam3.ArieScales;

import java.util.*;

public class ArieScales {
    List<Long> list = new LinkedList<>();

//    long target(int n, long[] w, long k) {
//        int max
//    }
    long target1(int n, long[] w, long k) {
        if (k > Math.pow(2, w.length))
            return -1L;
        if (k==1)
            return 0;
//
//        addToSet(w[0]);
//        addToSet(w[1]);
        long curSum = 0;
        for (int i = 0; i < n; i++) {
            if (list.size() >= k)
                break;
            if (i == 0 || i == 1) {
                curSum+=w[i];
                addToSet(w[i]);
                addToSet(curSum);
            } else {
                //if (curSum < w[i]) {
                    addToSet(curSum);
                    long curNum = w[i];
                    List<Long> tempList = new LinkedList<>();
                    for (int j = 0; j < list.size() ; j++) {
                        long nextNum = curNum + list.get(j);
                        if (w[i] < nextNum) {
                            tempList.add(w[i]);
                        }
                        tempList.add(curNum + list.get(j));

                    }
//                    curSum = tempList.get(tempList.size() - 1);
                    addAllToSet(tempList);


                //}
            }
        }

        //Collections.sort(list);
        list.add(0, 0L);
//        for (long l : list) {
//            System.out.print(l+ "," );
//        }
        return list.get(Integer.parseInt(String.valueOf(k))-1);
//        list.clear();
//        for (long l : list) {
//            long curNum = list.get(list.size() - 1);
//            List<Long> tempList = new LinkedList<>();
//
//            for (long j : list) {
//                tempList.add(curNum + j);
//            }
//
//            addAllToSet(tempList);
//
//        }
//        Collections.sort(list);
//        list.add(0, 0L);
//        for (long l : list) {
//            System.out.print(l+ "," );
//        }
//        System.out.println(list.get(Integer.parseInt(String.valueOf(k))-1));
//        return 1L;



    }

    private void addToSet(long ele) {
        if (!list.contains(ele)) {
            list.add(ele);
        }
    }
    private void addAllToSet(List<Long> list) {
        for (Long l : list) {
            addToSet(l);
        }
    }
    public static void main(String[] args) {
        long[] w = new long[]{100, 300, 700, 1300, 3000};
        System.out.println(new ArieScales().target1(5 ,w, 10));
    }
}
