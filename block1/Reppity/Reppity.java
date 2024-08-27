
public class Reppity {
    public int longestRep(String input) {
        int n = input.length();
        int[][] res = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (i > 0 && j - i <= res[i- 1][j-1]) {
                    res[i][j] = 0;
                } else if (input.charAt(i) == input.charAt(j) ) {
                    if (i - 1 < 0){
                        res[i][j] = 1;
                    } else {
                        res[i][j] = 1 + res[i-1][j-1];
                    }
                    max = Math.max(max, res[i][j]);
                }

            }
        }
        return max;
    }
}
