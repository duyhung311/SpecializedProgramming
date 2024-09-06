//package block3.MagicSpell;

public class MagicSpell {
    public String fixTheSpell(String spell) {
        int i = 0;
        int j = spell.length() - 1;

        do {
            for (int k = i; k < spell.length(); k++) {
                if (spell.charAt(k) == 'A' || spell.charAt(k) == 'Z') {
                    i = k;
                    break;
                }
            }
            for (int k = j; k > 0; k--) {
                if (spell.charAt(k) == 'A' || spell.charAt(k) == 'Z') {
                    j = k;
                    break;
                }
            }
            if (i < j) {
                spell = swapCharBetween(i, j, spell);
                i++;
                j--;
            }


        } while (i < j);
        return spell;
    }

    public String swapCharBetween(int i, int j, String s) {
        char[] ar = s.toCharArray();
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        return String.valueOf(ar);

    }


    public static void main(String[] args) {
        MagicSpell msp = new MagicSpell();
        System.out.println("AZBASGHNAZAHBNVZZGGGAGGZAZ");
        System.out.println(msp.fixTheSpell("AZBASGHNAZAHBNVZZGGGAGGZAZ").equals("ZABZSGHNAZZHBNVAZGGGAGGAZA"));
//        System.out.println("ZABZSGHNAZZHBNVAZGGGAGGAZA");
    }
}
