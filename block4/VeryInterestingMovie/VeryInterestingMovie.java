//package block4.VeryInterestingMovie;

public class VeryInterestingMovie {
    int maximumPupils (String[] seats) {
        int cnt = 0;
        for (int i = 0; i < seats.length; i++) {
            String[] chunks = seats[i].split("N");
            for (int j = 0; j < chunks.length; j++) {
                if (chunks[j].length()%2 == 0) {
                    cnt += chunks[j].length()/2;
                } else {
                    cnt += chunks[j].length()/2 +1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] seats = {"YYYYYYN","YYYYNYY","NYYYNYY","NYYYYYN","YYYYYYN","NYYNYNY","YYYYYYY"};
        System.out.println(new VeryInterestingMovie().maximumPupils(seats));
    }
}
