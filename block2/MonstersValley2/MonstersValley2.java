package block2.MonstersValley2;

import java.util.*;

    public class MonstersValley2 {
    public int minimumPrice1(int[] dread, int[] price) {
        int len = dread.length;
        int lastPrice = price[len - 1];
        int lastDread = dread[len - 1];
        int strength = dread[0];
        int coin = price[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i < len - 1; i++) {
            int lookForward = dread[i+1];
            if (lookForward > strength) {
                Integer lowerPrice = map.lowerKey(price[i]);

                if (lowerPrice != null) {
                    strength += map.get(lowerPrice);
                    coin += lowerPrice;
                } else {
                    strength += dread[i];
                    coin += price[i];
                }

            } else {
                map.put(price[i], dread[i]);
            }
        }

        if (strength < lastDread) {
            return coin + lastPrice;
        }

        return coin;
    }

    public int minimumPrice(int[] dread, int[] price) {
        long strength = dread[0];
        int coin = price[0];
        int di = 1;
        int pi = 1;

        return minimumPriceRecur(dread, price, di, pi, coin, strength);
    }

    public int minimumPriceRecur(int[] dread, int[] price, int di, int pi, int coinCumulative, long strengthCumulative) {
        if (di == dread.length || pi == price.length) {
            return coinCumulative;
        }
//        strengthCumulative += dread[di];
//        coinCumulative += price[pi];
        // 8,5, 10
        // at 5, it doesnt know there are 10 ahead
        if (strengthCumulative < dread[di] || (di <= dread.length-1  && dread[di + 1] > strengthCumulative + dread[di]) ) {
            return minimumPriceRecur(dread, price, di + 1, pi + 1, coinCumulative + price[pi], strengthCumulative + dread[di]);
        } else {
            return minimumPriceRecur(dread, price, di + 1, pi + 1, coinCumulative, strengthCumulative);
        }

    }

    public void run() {

        Integer[][] inputs = {{8, 5, 10}, {1, 1, 2},{1, 2, 4, 1000000000}, {1, 1, 1, 2}, {200, 107, 105, 206, 307, 400}, {1, 2, 1, 1, 1, 2},
                {5216, 12512, 613, 1256, 66, 17202, 30000, 23512, 2125, 33333},
                {2, 2, 1, 1, 1, 1, 2, 1, 2, 1}};
        int len = inputs.length;
        System.out.println(inputs[0]);
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < len; ) {
            List<Integer> list = new ArrayList<>();
            Arrays.asList(inputs[0]);

            i+=2;
            arr.add(list);
        }

//        for (Map.Entry<List<Integer>, Integer> testCase : testCases.entrySet()) {

//        arr.add(Arrays.asList(new Integer[]{8, 5, 10}));

        int res = minimumPrice(new int[]{8,5,10}, new int[]{1, 1, 2});
            if (!Integer.valueOf(2).equals(res)) {
                throw new RuntimeException("Error: " + " with res = " + res);
            }
//        }
        System.out.println("Testcases all                                                              ");

    }

}
