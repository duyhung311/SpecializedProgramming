package diag.SecondChild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
                names.add(elements[1]);
                names.add(elements[0]);
            }
            else  {
                elements = mather.split(" ");
                names.add(elements[1]);
                names.add(elements[0]);
            }
        } else { //rule 2
            if (gender.equals("Boy")) {
                String firstName = father.split(" ")[0];
                String secondName = child1.split(" ")[1];
                names.add(firstName);
                names.add(secondName);
            }
            else  {
                String firstName = mather.split(" ")[0];
                String secondName = child1.split(" ")[1];
                names.add(firstName);
                names.add(secondName);
            }
        }
        return names.stream().collect(Collectors.joining(" "));
    }
}

