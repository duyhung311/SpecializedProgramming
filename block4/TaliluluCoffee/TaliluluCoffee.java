//package block4.TaliluluCoffee;

import java.util.Arrays;


public class TaliluluCoffee {
    int maxTip(int[] tips) {
        Arrays.sort(tips);
        int sum = 0;
        int sumRev = 0;
        for (int i = 0; i < tips.length - 1; i++) {
            if (tips[i] - i >= 0) {
                sum += (tips[i] - i);
            }
        }
        int j = 0;
        for (int i = tips.length - 1; i >=0; i--) {
            if (tips[i] - j >= 0) {
                sumRev += (tips[i] - j);
            }
            j++;
        }

        return Math.max(sum, sumRev);
    }

    public static void main(String[] args) {
        int[] tips = {7, 8, 6, 9, 10};
        System.out.println(new TaliluluCoffee().maxTip(tips));
    }
}
