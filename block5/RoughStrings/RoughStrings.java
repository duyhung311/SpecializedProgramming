//package block5.RoughStrings;

public class RoughStrings {

    public int minRoughness(String s, int n) {
        int[] occurrences = new int[26];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            occurrences[c - 'a']++;
            if (occurrences[c - 'a'] > max) {
                max = occurrences[c - 'a'];
            }
        }

        for (char c : s.toCharArray()) {
            if (occurrences[c - 'a'] < min) {
                min = occurrences[c - 'a'];
            }
        }
        if (min == 0) {
            min = max;
        }

        if (min + max <= n) {
            return 0;
        } else {
            if (min < n) { // min processing
                n -= min;
                min = 0;

                max -= n;
                return max - min;
            } else {
                return max - min - n;
            }
        }


    }

    public static void main(String[] args) {
        String s = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        int n = 17;
        System.out.println(new RoughStrings().minRoughness(s, n));
    }
}
