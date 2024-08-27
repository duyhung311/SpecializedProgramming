import java.util.HashSet;
import java.util.Set;

public class LuckyNumbers {
    public int countLucky(int[] a, int[] b, int[] c) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            for (int j : b) {
                for (int k : c) {
                    int sum = i + j  + k;
                    if (check58(sum) && !set.contains(sum)) {
                        System.out.println(i + " " + j + " " + k + " = " + sum);
                        count++;
                        set.add(sum);
                    }
                }
            }
        }
        return count;
    }

    private boolean check58(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '5' && s.charAt(i) != '8') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {6213, 3, 960, 3, 52, 3, 3481};

        LuckyNumbers l = new LuckyNumbers();
        System.out.println(l.countLucky(a,a,a));
    }
}
