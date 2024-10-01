//package block4.SimpleCompressor;

import java.util.*;

public class SimpleCompressor {
    public String uncompress (String s) {
        Stack<String> operands = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder ele = new StringBuilder();
                while (!operands.empty() && !operands.peek().equals("[") && !isNumber(operands.peek())) {
                    ele.insert(0, operands.pop());
                }
                int len = Integer.parseInt(operands.pop());
                operands.pop();
                operands.push(dupString(len, ele.toString()));


            }
            else operands.push(String.valueOf(s.charAt(i)));

        }


        List<String> appendResult = new LinkedList<>();
        while (!operands.empty()) {
            String e = operands.pop();
            if (!Objects.equals(e, "]")) {
                appendResult.add(0, e);
            }
        }
        return String.join("", appendResult);


    }
    boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }

    }
    private String dupString(int times, String s) {
        return String.valueOf(s).repeat(Math.max(0, times));
    }

    public static void main(String[] args) {
        Map<String, String> testCases = new HashMap<>();
        testCases.put("C[6AB]C", "CABABABABABABC");
        testCases.put("C[2[3AB]]D", "CABABABABABABD");
        testCases.put("CO[1N]TEST", "CONTEST");
        testCases.put("[2[2AB]]", "ABABABAB");
        testCases.put("AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA");
        SimpleCompressor compressor = new SimpleCompressor();
        for (Map.Entry<String, String> entry : testCases.entrySet()) {
            String res = compressor.uncompress(entry.getKey());
            if (!res.equals(entry.getValue())) {
                throw new RuntimeException(res + " != " + entry.getValue());
            }
        }
        System.out.println("Test cases all passed");
    }
}
