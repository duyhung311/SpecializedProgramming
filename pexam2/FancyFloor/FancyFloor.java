//package pexam2.FancyFloor;

import java.util.Objects;

public class FancyFloor {
    public int howmanyBoards(String[] layout) {
        int cntDash = 0;
        for (String currentLayout : layout) {
            int j = 0;
            boolean flag = false;
            while (j  < currentLayout.length()) {
                if ((flag && currentLayout.charAt(j) != '-') || (flag && j == currentLayout.length() - 1)) {
                    flag = false;
                    cntDash++;
                    //j = j + 1;
                } else if (!flag && currentLayout.charAt(j) == '-') {
                    flag = true;
                    //j++;
                } else if ((flag && currentLayout.charAt(j) == '-') || j == currentLayout.length() - 1) {
                    //j++;
                }
                j++;

            }
            if (flag)
                cntDash++;
        }
        int col = layout[0].split("").length;
        int row = layout.length;
        int cntSth = 0;


        for(int i = 0; i < col; i++) {
            boolean flag = false;
            int j = 0;
            while (j < row) {
                String curLayout = layout[j].split("")[i];
                if ((flag && !Objects.equals(curLayout, "|")) || (flag && j == row - 1)) {
                    flag = false;
                    cntSth++;
                    //j++;
                } else if (!flag && Objects.equals(curLayout, "|")) {
                    flag = true;
                    //j++;
                } else if ((flag && curLayout.equals("|")) || j == row - 1) {
                    //j++;
                }
                j++;
            }
            if (flag) {
                cntSth++;
            }
        }

        return cntDash + cntSth;
    }

    public static void main(String[] args) {
        String[] layout = {
                "-||--||--",
                "--||--||-",
                "|--||--||",
                "||--||--|",
                "-||--||--",
                "--||--||-"
        };
        System.out.println(new FancyFloor().howmanyBoards(layout));
    }
}
