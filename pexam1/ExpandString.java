package pexam1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class ExpandString {

    public int howLong(String s) {
        Stack<String> operands = new Stack<>();
        StringBuilder res= new StringBuilder();
        int currentLen = 0;
        long resS = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
//                StringBuilder ele = new StringBuilder();
//                while (!operands.empty() && !operands.peek().equals("(")) {
//                    ele.append(operands.pop());
//                }
                int len = Integer.parseInt(operands.pop());
                operands.pop();
                int times = Integer.parseInt(operands.pop());
                //operands.push(dupString(times, ele.toString()));
                operands.push(String.valueOf(times*len));
                currentLen = times * len;
//                res.append(dupString(times, ele.toString()));

            }
            else operands.push(String.valueOf(s.charAt(i)));

        }
        if (!operands.empty()) {
            StringBuilder ele = new StringBuilder();
            while (!operands.empty()) {
                String e = operands.pop();
                if (!Objects.equals(e, ")")) {
                    ele.append(e);
                }
            }
            String a = ele.append(res).toString();
            return a.length();
        }
        Set<Integer> a = new HashSet<>();
        
        return currentLen;


    }

    private String dupString(int times, String s) {
        return String.valueOf(s).repeat(Math.max(0, times));
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
        System.out.println(expandString.howLong("9(9(9(6(4(9(9(9(9(9(34))))))))))"));
    }
}
