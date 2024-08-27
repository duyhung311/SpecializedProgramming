
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NiceBoxes {
    int minRemove(int a, int b, int c) {
        if (b == 1 || c ==1 )
            return -1;
        if ( b > a && c > b)
            return 0;
        if (b < 2 || c < 3)
            return -1;

        int cnt =  0;

        int bTarget = c - 1;
        if (b >= bTarget) {
            int candyToEat = b - bTarget;
            cnt += (candyToEat);
            b -= candyToEat;
        }

        int aTarget = b - 1;
        if (a >= aTarget) {
            int candyToEat = a - aTarget;
            cnt += candyToEat;
            a -= candyToEat;
        }


        return cnt;

    }

    public static void main(String[] args) {
        NiceBoxes niceBoxes = new NiceBoxes();

        System.out.println(niceBoxes.minRemove(6,4,2));
    }
}
