//package block4.JumpyNum;

public class JumpyNum {
    int[][] dp;
    public int howMany(int low, int high) {
        howManyOpDp();
        return howMany(high+1) - howMany(low);


    }

    int howMany(int phigh){ // # < phigh
        String h = Integer.toString(phigh);
        int ret = 0;
        for (int i = 1; i < h.length(); i++){
            for (int d = 1; d < 10; d++){
                ret += dp[i][d];
            }
        }

        for (int i = 0; i < h.length(); i++){
            // differ at h[i]
            int convert1 = Integer.parseInt(h.charAt(i)+"");
            for (int d = i == 0 ? 1 : 0; d < convert1; d++){
                if (i > 0) {
                    int convert2 = Integer.parseInt(h.charAt(i-1)+"");
                    if (Math.abs(convert2 - d) < 2)
                        continue;
                }

//                if(i > 0 && Math.abs(convert2 - d) < 2)
//                    continue;
                ret += dp[h.length()-i][d];
            }
            if(i > 0 && Math.abs(h.charAt(i)-h.charAt(i-1)) < 2)
                break;
        }
        return ret;
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

    private void howManyOpDp() {
        dp = new int[11][10];
        for (int d = 0; d < 10; d++){
            dp[1][d] = 1;
        }
        for (int n = 2; n <= 10; n++){
            // find DP[n]
            for (int d = 0; d < 10; d++){
                for (int e = 0; e < 10; e++){
                    if(Math.abs(d-e) >= 2)
                        dp[n][d] += dp[n-1][e];
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new JumpyNum().howMany(1,
                10));
    }

}
