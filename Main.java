import block2.MonstersValley2.MonstersValley2;
import diag.BootsExchange.BootsExchange;

public class Main {
    public static void main(String[] args) {
        // SecondChild secondChild = new SecondChild();
        // String a = secondChild.chooseName("Mohammad Reza", "Yasaman Sadat", "Umi Kulsum", "Girl");
        // System.out.println(a);
        
        BootsExchange bootsExchange = new BootsExchange();
        int[] left = {3, 1, 4, 7, 3, 1, 4, 5, 1};
        int[] right = {2, 5, 2, 3, 4, 1, 4, 6, 8};           

//        MooingCows mooingCows = new MooingCows();
//        String[] farmland = {
//                "CCCC",
//                "CCCC",
//                "CCCC"
//        };
//        int res = mooingCows.dissatisfaction(farmland);
        MonstersValley2 m = new MonstersValley2();
        m.run();
        System.out.println();
    }
}   