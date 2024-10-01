package block4.JumpyNum;

public class JumpyNum {
    public int howMany(int low, int high) {
        if (low ==  high) {
            return 0;
        }
        int[] dp = new int[high + 1];
        dp[0] = 0;
        for (int i = low; i <= high; i++) {
            howManyDp(i, dp);
        }
        return dp[high];
    }

    private int howManyDpRecursive(int num, int acc, int low, int high) {
        int nextNum;
        if (num == high) {
            return acc;
        }
        if (num < 10)
            acc++;
        else {
            String a = String.valueOf(num);
            char[] ar = a.toCharArray();
            boolean flag = true;
            for (int i = 0; i < ar.length -1; i++) {
                int b = Integer.parseInt(String.valueOf(ar[i]));
                int c = Integer.parseInt(String.valueOf(ar[i+1]));
                if (Math.abs(b - c) <  2) {
                    flag = false;

                    break;
                }
            }
            if (flag) {
                acc++;

            }

        }
        return howManyDpRecursive(num + 1, acc, low, high);



    }

    private void howManyDp(int num, int[] dp) {
        int index = num;
        if (dp[index] != -1) {
            if (num < 10)
                dp[index] = dp[index-1] + 1;
            else {
                String a = String.valueOf(num);
                char[] ar = a.toCharArray();
                boolean flag = true;
                for (int i = 0; i < ar.length -1; i++) {
                    int b = Integer.parseInt(String.valueOf(ar[i]));
                    int c = Integer.parseInt(String.valueOf(ar[i+1]));
                    if (Math.abs(b - c) <  2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    dp[index] = dp[index-1] + 1;
                } else {
                    dp[index] = dp[index-1];
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new JumpyNum().howMany(2_000_000_000,
                2_000_000_000));
    }

}
