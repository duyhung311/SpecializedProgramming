//package block2.MonstersValley2;
public class MonstersValley2 {


    public int minimumPrice(int[] dread, int[] price) {
        long strength = 0;
        int coin = 0;
        int i = 0;
        if (dread.length == 1) {
            return price[0];
        }
        return minimumPriceRecur(dread, price, i, coin, strength);
    }

    public int minimumPriceRecur(int[] dread, int[] price, int i, int coinCumulative, long strengthCumulative) {
        if (i == dread.length) {
            return coinCumulative;
        }
        if (strengthCumulative < dread[i]) {
            return minimumPriceRecur(dread, price, i+1, coinCumulative + price[i], strengthCumulative + dread[i]);
        } else {
            return Math.min(
                    minimumPriceRecur(dread, price, i+1, coinCumulative, strengthCumulative),
                    minimumPriceRecur(dread, price, i+1, coinCumulative + price[i], strengthCumulative + dread[i]));
        }

    }

    public void run() {

//        Integer[][] inputs = {{11, 2, 4}, {12, 6, 4}, {20, 3, 7}, {21, 7, 3}, {15, 16, 5}, {1000, 3, 7}, {1000, 7, 3}};
//        Map<List<Integer>, Integer> testCases = new HashMap<>();
//        testCases.put(Arrays.asList(inputs[0]), 3);
//        testCases.put(Arrays.asList(inputs[1]), 2);
//        testCases.put(Arrays.asList(inputs[2]), 1);
//        testCases.put(Arrays.asList(inputs[3]), 2);
//        testCases.put(Arrays.asList(inputs[4]), 1);
//        testCases.put(Arrays.asList(inputs[5]), 48);
//        testCases.put(Arrays.asList(inputs[6]), 48);
//        for (Map.Entry<List<Integer>, Integer> testCase : testCases.entrySet()) {
        int res = minimumPrice(new int[]{200, 107, 105, 206, 307, 400}, new int[]{1, 2, 1, 1, 1, 2});
            if (!Integer.valueOf(2).equals(res)) {
                throw new RuntimeException("Error: " + " with res = " + res);
            }
//        }
        System.out.println("Testcases all passed");

    }

    public static void main(String[] args) {
        MonstersValley2 mv = new MonstersValley2();
        mv.run();
    }
}
