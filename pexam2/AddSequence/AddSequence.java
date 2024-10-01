package pexam2.AddSequence;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class AddSequence {
    public int MinX(int[] S) {
        Arrays.sort(S);

        Set<Integer> set = new TreeSet<>();
        int[] bin = new int[S.length];
        int max = Integer.MIN_VALUE;
        for (int i = bin.length-1; i >=0; i--) {
            bin[i] = 1;
            
            int sum = 0;
            for (int j = 0; j < bin.length; j++ ) {
                if (bin[j] == 1) {
                    sum += S[j];
                }
                max = Math.max(max, sum);
                set.add(sum);
            }
        }
        int[] binTemp = bin;
        for (int i = bin.length-1; i >=0; i--) {
            bin[i] = 0;
            int sum = 0;
            for (int j = 0; j < bin.length; j++ ) {
                if (bin[j] == 1) {
                    sum += S[j];
                }
                max = Math.max(max, sum);
                set.add(sum);
            }
        }
        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }

    int minXRecursive(int[] S) {
        return 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 26, 14, 28, 15, 3, 3, 35, 1, 2, 212, 30, 126};
        System.out.println(new AddSequence().MinX(a));

    }
}
