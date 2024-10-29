//package block5.BlackAndWhiteSolitaire;

public class BlackAndWhiteSolitaire {
        public int minimumTurns(String s) {
            int i = 0;
            int cntB = 0;
            while (i < s.length()) {
                if (i%2 == 0) {
                    if (s.charAt(i) != 'B') {
                        cntB++;
                    }
                } else {
                    if (s.charAt(i) != 'W') {
                        cntB++;
                    }
                }
                i++;
            }
            int cntW = 0;
            i = 0;
            while (i < s.length()) {
                if (i%2 == 0) {
                    if (s.charAt(i) != 'W') {
                        cntW++;
                    }
                } else {
                    if (s.charAt(i) != 'B') {
                        cntW++;
                    }
                }
                i++;
            }
            return Math.min(cntB, cntW);
        }


    public static void main(String[] args) {
          String a= "BBWBWWBWBWWBBBWBWBWBBWBBW";
//          String a= "0010110101100010101001001";
//        String a= "BwbwbWBWBWbwBwbwbwbwBWBwb";
//        String a= "wBWBWbwbwbWBwBWBWBWBwbwBW"; //10
        System.out.println(new BlackAndWhiteSolitaire().minimumTurns(a));
    }
}

