import java.util.Objects;
import java.util.Stack;

public class ExpandString {

    public int howLong(String s) {
        Stack<String> operands = new Stack<>();
        StringBuilder res= new StringBuilder();
        int cnt= 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                StringBuilder ele = new StringBuilder();
                while (!operands.empty() && !operands.peek().equals("(")) {
                    ele.append(operands.pop());
                }
                operands.pop();
                int times = Integer.parseInt(operands.pop());
                //operands.push(dupString(times, ele.toString()));
                cnt += dupString(times, ele.toString());
//                res.append(dupString(times, ele.toString()));

            }
            else operands.push(String.valueOf(s.charAt(i)));

        }
        if (!operands.empty()) {
            StringBuilder ele = new StringBuilder();
            while (!operands.empty()) {
                String e = operands.pop();
                if (!Objects.equals(e, ")")) {
                    ele.append(e); // with String repeat
                }
            }
            String a = ele.append(res).toString();
            cnt += dupString(Integer.parseInt(a), ele.toString());
            return a.length();
        }
        return res.length();

    }

    private int dupString(int times, String s) {
        return times * s.length();
    }

    boolean isNumber(char s) {
        try {
            Integer.parseInt(String.valueOf(s));
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }

    }

    public static void main(String[] args) {
        ExpandString expandString = new ExpandString();
        System.out.println(expandString.howLong("9(9(9(6(4(9(9(9(9(9(34))))))))))")); // -> 19
    }
}
