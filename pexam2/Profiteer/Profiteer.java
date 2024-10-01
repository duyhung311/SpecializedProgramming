//package pexam2;

public class Profiteer {
    public int maxProfit(String places) {
        if (places.length() == 1) {
            return 1;
        }
        int c = 0;
        int v = 0;
        for (int i = 0; i < places.length(); i++) {
            if (places.charAt(i) == 'V') {
                v+=1;
            } else {
                c+=1;
            }
        }
        if (v == c)
            return v + c;
        return Math.min(c, v)*2 + 1;
    }
}
