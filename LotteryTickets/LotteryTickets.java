package LotteryTickets;

import java.util.Arrays;

public class LotteryTickets {
    int price = 1000;
    int b1 = 700;
    int b2 = 100;
    int b3 = 120;
    int b4 = 200;
    int[] bs = {700,100,120,200};
    final String IMPOSSIBLE = "IMPOSSIBLE";
    final String POSSIBLE = "POSSIBLE";
    public String buy() {
        if (b1+b2+b3+b4 < price) {
            return IMPOSSIBLE;
        }
        if (b1+b2+b3+b4 == price) {
            return POSSIBLE;
        }
        int sum = 0;
        Arrays.sort(bs);
        for (int i = 0; i < bs.length; i++) {
            sum += bs[i];
            if (sum == price) {
                return POSSIBLE;
            }
            for (int j = i + 1; j < bs.length; j++) {
                sum += bs[j];
                if (sum == price) {
                    return POSSIBLE;
                }
            }
            sum = 0;
        }
        return IMPOSSIBLE;
    }
}
