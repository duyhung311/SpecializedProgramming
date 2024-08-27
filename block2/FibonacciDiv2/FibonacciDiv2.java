//package block2.FibonacciDiv2;

public class FibonacciDiv2 {
    int[] fibs = new int[32];
    public int find(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        if (n < 3)
            return 1;
        fibs[1] = 1;
        fibs[2] = 1;

        return findRecursive(n, 3);
    }

    public int findRecursive(int n, int pointer) {
        fibs[pointer] = fibs[pointer-1] + fibs[pointer-2];
        int currentFib = fibs[pointer];
        if (currentFib == n) {
            return 0;
        } else if (currentFib > n) {
            int prev = fibs[pointer-1];
            return Math.min(n-prev, currentFib -n);
        }
        return findRecursive(n, pointer + 1);
    }

    public static void main(String[] args) {
        FibonacciDiv2 fib = new FibonacciDiv2();
        System.out.println(fib.find(2));
    }
}
