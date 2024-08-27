import java.util.*;

public class GameOfSets {
    //3
    //two oval purple striped
    //one squiggle purple solid
    //three diamond purple empty
    private static int n;
    private static List<String> numbers = new ArrayList<>();
    private static List<String> shapes = new ArrayList<>();
    private static List<String> colors = new ArrayList<>();
    private static List<String> shadings = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(9.499999999999999 > 9.5);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            numbers.add(input[0]);
            shapes.add(input[1]);
            colors.add(input[2]);
            shadings.add(input[3]);
        }
        numbers.forEach(System.out::println);
        shapes.forEach(System.out::println);
        colors.forEach(System.out::println);
        shadings.forEach(System.out::println);
        Set<String> s = new HashSet<>();
    }

    private void checkSet() {

    }
}
