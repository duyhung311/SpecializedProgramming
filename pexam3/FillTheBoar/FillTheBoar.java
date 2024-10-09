//package pexam3.FillTheBoar;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class FillTheBoar {

    public int eaten(int stomach, int[] muffins, int delay) {
        Arrays.sort(muffins);
        Collections.sort(Arrays.asList(delay), Collections.reverseOrder());

        Arrays.sort(muffins);
        int[]  newMuffins = new int[muffins.length];
        int p = 0;
        for (int i = muffins.length - 1; i >= 0; i--) {
            newMuffins[p++] = muffins[i];
        }
        muffins = newMuffins;
        int curStomach = 0;

        int i = 0;
        while (i < muffins.length && curStomach + muffins[i] <= stomach) {
            curStomach += muffins[i++];
        }
//        System.out.println(curStomach);
        if (curStomach <  stomach && i >= muffins.length) {
            return curStomach;
            // not enough
        }
        if (curStomach == stomach) {
            return curStomach;
        }
        if (delay == 0) {
            return curStomach + muffins[i];
        }

        int start = i;
        i+=(delay);
//        if (i < muffins.length) {
        int tempCurStomach = curStomach;
//        for (int j = start; j < i; j++) {
//            curStomach += muffins[j];
//        }
        int j = start;
        int cntDelay = 0;
        while ( j < muffins.length && cntDelay < delay) {
            curStomach += muffins[j++];
            cntDelay++;
        }
        if (tempCurStomach <= stomach) {
            return curStomach  + muffins[i];
        }
        return curStomach;
//        } else {
//            return 0;
//        }


    }

    public static void main(String[] args) {
        int stomach = 100 ;
        int[] mufffins1 = {100001, 100002, 100003};
        int[] mufffins = {100, 100, 100};
        int[] mufffins2 = {1000, 8000, 2000, 5000, 3000};
        int delay = 0;
        System.out.println(new FillTheBoar().eaten(stomach, mufffins, delay));
    }
}
