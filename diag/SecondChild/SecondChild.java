package diag.SecondChild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SecondChild {
    public String chooseName(String father, String mather, String child1, String gender) {

        char child1FirstChar = child1.toLowerCase().charAt(0);
        Character[] vowels = new Character[]{'a','e','i','u','o', 'y'};
        String child1Gender = Arrays.asList(vowels).contains(child1FirstChar) ? "Girl" : "Boy";
        List<String> names = new ArrayList<>();
        if (!child1Gender.equals(gender)) { // rule 1
            String[] elements;
            if (gender.equals("Boy")) {
                elements = father.split(" ");
            }
            else  {
                elements = mather.split(" ");
            }
            names.add(elements[1]);
            names.add(elements[0]);
        } else { //rule 2
            String firstName;
            String secondName = child1.split(" ")[1];
            if (gender.equals("Boy")) {
                firstName = father.split(" ")[0];
            }
            else  {
                firstName = mather.split(" ")[0];
            }
            names.add(firstName);
            names.add(secondName);
        }
        return String.join(" ", names);
    }
}

