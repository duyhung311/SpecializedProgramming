package block3.UnsealTheSafe;

public class UnsealTheSafe {

    public long countPasswords(int n) {
        long[][] memo = new long[n + 2][10];

        for (int i = 0; i <= 9; i++) {
            memo[1][i] = 1;
        }

        for (int i = 2; i <= n ; i++) {
            int takePreviousLine, j = i - 1;
            memo[i][0] = memo[j][7];
            memo[i][1] = memo[j][2] + memo[j][4];
            memo[i][2] = memo[j][1] + memo[j][3] + memo[j][5];
            memo[i][3] = memo[j][2] + memo[j][6];
            memo[i][4] = memo[j][1] + memo[j][5] + memo[j][7];
            memo[i][5] = memo[j][2] + memo[j][4] + memo[j][6] + memo[j][8];
            memo[i][6] = memo[j][3] + memo[j][5] + memo[j][9];
            memo[i][7] = memo[j][4] + memo[j][8] + memo[j][0];
            memo[i][8] = memo[j][7] + memo[j][5] + memo[j][9];
            memo[i][9] = memo[j][6] + memo[j][8];
        }
        long cnt = 0;
        for (int i = 0; i < memo[0].length; i++) {
            cnt += memo[n][i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        UnsealTheSafe unseal = new UnsealTheSafe();
        System.out.println(unseal.countPasswords(25) == 768478331222L);
    }
}
