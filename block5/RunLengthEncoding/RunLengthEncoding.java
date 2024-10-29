//package block5.RunLengthEncoding;

public class RunLengthEncoding {
    String decode(String text) {
        String current = "";
        int d;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                current += ("") +  text.charAt(i);
                if (current.length() >= 3) {
                    return "TOO LONG";
                }
            } else {
                if (current.isBlank())
                    current = "1";
                d = Integer.parseInt(current);

                builder.append(dupString(d, String.valueOf(text.charAt(i))));
                if (builder.length() > 50) {
                    return "TOO LONG";
                }
                current = "";

            }
        }

        return builder.toString();
    }

    private String dupString(int times, String s) {
        return String.valueOf(s).repeat(Math.max(0, times));
    }

    public static void main(String[] args) {
        String i = "123456789012345678901234567890B";
        System.out.println(new RunLengthEncoding().decode(i));
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //AAAABBBCDDE
    }
}
