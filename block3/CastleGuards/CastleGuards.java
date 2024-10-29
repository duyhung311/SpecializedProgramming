package block3.CastleGuards;

import java.util.Objects;

public class CastleGuards {
    int missing(String[] castle) {
        int zeroGuardsInRow = 0;
        int zeroGuardInCol = 0;
        int numberOfPosition = castle[0].length();
        int[] rowsCnt = new int[castle.length];
        int[] colsCnt = new int[numberOfPosition];
        for(int i = 0; i < castle.length; i++){
            String[] castlePosition = castle[i].split("");
            for (int j = 0; j < castlePosition.length; j++){
                if (Objects.equals(castlePosition[j], "X")){
                    rowsCnt[i] = 1;
                    colsCnt[j] = 1;
                }
            }
            if(rowsCnt[i] == 0){
                zeroGuardsInRow++;
            }
        }
        for(int i = 0; i < castle[0].length(); i++){
            if(colsCnt[i] == 0){
                zeroGuardInCol++;
            }
        }
		return Math.max(zeroGuardInCol, zeroGuardsInRow);
    }

    public static void main(String[] args) {
        String[] castle = { "XX...", ".XX..", "...XX"};
        System.out.println(new CastleGuards().missing(castle));

    }
}
