//package block3.TimeTravellingCellar;

public class TimeTravellingCellar {
    public int determineProfit(int[] profit, int[] decay) {
        int n = decay.length, best = 0;

        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
                if(profit[i]-decay[j] > best && j != i  )
                    best = profit[i]-decay[j];
        return best;

    }

    public static void main(String[] args) {
        int[] profit = {1030, 279, 9400, 9270, 1333, 1401, 6918, 5986 };
        int[] decay = {7104, 6890, 526, 1252, 3651, 6313, 8445, 7023};
        System.out.println(new TimeTravellingCellar().determineProfit(profit, decay));
    }
}
