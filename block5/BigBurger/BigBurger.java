//package block5.BigBurger;

public class BigBurger {
    public int maxWait(int[] arrival, int[] service) {
        if (arrival.length == 1) {
            return 0;
        }
        int nextOrder = 0;
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] < nextOrder) {
                maxTime = Math.max(maxTime, nextOrder - arrival[i]);
                nextOrder += service[i];
            } else {
                nextOrder = arrival[i]  + service[i];
            }

        }
        if (maxTime == Integer.MIN_VALUE) {
            return 0;
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] arrival = {100, 200, 300, 400, 500, 600, 700};
        int[] services = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(new BigBurger().maxWait(arrival, services));
    }
}


//int swapsForEvenPositions = 0;
//int swapsForOddPositions = 0;
//int onesCount = 0;
//
//	for (int i = 0; i < s.length(); i++) {
//        if (s.charAt(i) == '0') {
//        if (i % 2 == 0)
//swapsForEvenPositions++;
//        else
//swapsForOddPositions++;
//        } else
//onesCount++;
//        }
//
//        // to form an alternating string, count of ones
//        // and zeroes should be atmost 1
//        if (Math.abs(s.length() - 2 * onesCount) > 1)
//        return -1;
//
//        // if the string length is odd, it means either of the two
//        // onesCount = 1 + zeroCount, or zeroCount = 1 + onesCount
//        if (s.length() % 2 == 1) {
//
//        // if onesCount is greater than zeroCount, then the even
//        // positions should have 1; return swapsForEvenPositions
//        // otherwise return swapsForOddPositions
//        if (onesCount > s.length() - onesCount)
//        return swapsForEvenPositions;
//		else
//                return swapsForOddPositions;
//	}
//
//            // when string length is even, return the min of the swaps
//            // required for even and odd places
//            return Math.min(swapsForEvenPositions, swapsForOddPositions);
