//package block2.EggCartons;

public class EggCartons {
    public int minCartons(int n) {
      if (n < 6 || n%2!=0) {
          return -1;
      }
      int min = Integer.MAX_VALUE;
      for (int i = 0; i <= 17; i++) {
          for (int j = 0; j <= 17; j++) {
              if (8*i + 6*j == n) {
                  min = Math.min(min, i+j);
              }
          }
      }
      if (min == Integer.MAX_VALUE) {
          return -1;
      }

      return min;
    }

    public static void main(String[] args) {
        EggCartons eggCartons = new EggCartons();
        System.out.println(eggCartons.minCartons(13));
    }

}
