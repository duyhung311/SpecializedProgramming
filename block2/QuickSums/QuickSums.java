

public class QuickSums {

    public int minSums(String number, int sum) {
        int res = min(number,sum);
        if (res == -1) {
            return -1;
        }
        return res - 1;
    }

    private int min(String equation, int sum) {
        if (sum(equation) == sum) {
            return 1;
        } else if (sum(equation) < sum) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < equation.length(); i++) {
            if (equation.charAt(i) != '+' && equation.charAt(i-1) != '+') {
                String operand1 = equation.substring(0, i);
                String operand2 = equation.substring(i);
                int r = min(operand1.concat("+").concat(operand2), sum);
                if (r  != -1) {
                    res = Math.min(res, r);
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res + 1;

    }

    private int sum(String equation) {
        String[] operands = equation.split("\\+");
        long sum =0;
        for (String operand : operands) {
            sum+=Long.parseLong(operand);
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        QuickSums qs = new QuickSums();
        System.out.println(qs.minSums("123123", 12315));
    }
}
