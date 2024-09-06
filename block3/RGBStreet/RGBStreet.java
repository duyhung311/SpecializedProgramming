//package block3.RGBStreet;

public class RGBStreet {
    int len;
    int estimateCost(String[] houses) {
        int min = Integer.MAX_VALUE;
        len = houses.length;

        String[] firstHouse = houses[0].split(" ");
        return Math.min(
                estimate(0, min, firstHouse[0], 0),
                Math.min(
                        estimate(0, min, firstHouse[1], 0),
                        estimate(0, min, firstHouse[2], 0)
                )
        );

    }

    /**
     *
     * @param lastHouseIndex indicates which color in R G B was painted previously
     * @param min            indicate current min
     * @param nextHouse      indicate cost of this recursion step to be added to min before comparing
     * @param currentHouse   indicate the current house index
     * @return the minimum cost of a house choosing path.
     */
    private int estimate(int lastHouseIndex, int min, String nextHouse, int currentHouse) {
        if (currentHouse == len){
            return min;
        }
        String[] house = nextHouse.split(" ");
        int[] houseCost = new int[house.length];

        for (int i = 0; i < houseCost.length; i++) {
            houseCost[i] = Integer.parseInt(house[i]);
        }

        if (lastHouseIndex == 0) {
            return Math.min(
                    estimate(1, min + houseCost[1], house[1], currentHouse+1),
                    estimate(2, min  + houseCost[2], house[2], currentHouse+1)
            );
        } else if (lastHouseIndex == 1) {
            return Math.min(
                    estimate(0, min + houseCost[0], house[0], currentHouse+1),
                    estimate(2, min + houseCost[2], house[2], currentHouse+1)
            );
        } else {
            return Math.min(
                    estimate(0, min + houseCost[0], house[0], currentHouse+1),
                    estimate(1, min + houseCost[1], house[1], currentHouse+1)
            );
        }
    }
}
