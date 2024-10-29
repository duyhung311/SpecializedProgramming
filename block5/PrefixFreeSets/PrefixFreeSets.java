//package block5.PrefixFreeSets;

import java.util.Objects;

public class PrefixFreeSets {
    public static int maxElements(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(words[i], "6")) {
                String checking = words[i];
                for (int j = 0; j < words.length; j++) {
                    if (i != j) {
                        if (words[j].startsWith(checking)) {
                            // System.out.println("dis");
                            words[i] = "6";
                            break;
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(words));
        int result = 0;
        for (String word : words) {
            if (Objects.equals(word, "6")) {
                continue;
            }
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"hello","hi","h","run","rerun","running"};
        System.out.println(new PrefixFreeSets().maxElements(words));
    }
}
