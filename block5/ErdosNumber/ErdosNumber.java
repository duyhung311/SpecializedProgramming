//package block5.ErdosNumber;


import java.io.*;
import java.util.*;

public class ErdosNumber {

    private final Map<String, Set<String>> graph = new HashMap<>();

    public void addPublication(String[] authors) {
        for (String author : authors) {
            graph.putIfAbsent(author, new HashSet<>());
            for (String coAuthor : authors) {
                if (!author.equals(coAuthor)) {
                    graph.get(author).add(coAuthor);
                }
            }
        }
    }

    public int calculateErdosNumber(String researcher) {
        if (researcher.equals("ERDOS"))
            return 0;
        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> erdosNumbers = new HashMap<>();

        queue.add("ERDOS");
        erdosNumbers.put("ERDOS", 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentNumber = erdosNumbers.get(current);

            for (String neighbor : graph.getOrDefault(current, Collections.emptySet())) {
                if (!erdosNumbers.containsKey(neighbor)) {
                    erdosNumbers.put(neighbor, currentNumber + 1);
                    queue.add(neighbor);
                    if (neighbor.equals(researcher)) {
//                        authorErdosNumber.put(neighbor, erdosNumbers.get(neighbor));
                        return erdosNumbers.get(neighbor);
                    }
                }
            }
        }
        return -1; // If no connection found
    }

    public String[] calculateNumbers(String[] publications) {
        for (String publication : publications) {
            addPublication(publication.split(" "));
        }
        Map<String, Integer> res = new TreeMap<>();
        Set<String> authors = graph.keySet();
        for (String author : authors) {
            res.put(author, calculateErdosNumber(author));
        }

        return res.entrySet().stream().map(x -> {
            if (x.getValue() == -1) {
                return x.getKey();
            } else {
                return x.getKey() + " " + x.getValue();
            }
        }).distinct().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] publications = {"ERDOS A", "A B", "B AA C"};
        String[] publications3 = {"ERDOS"};
        String[] publications1 = {"ERDOS B", "A B C", "B A E", "D F"};
        String[] publications2 = {"ERDOS Q W E R T Y U I O P A S D F G H J K L Z X",
                "AA AB AC AD AE AF AG AH AI AJ AK AL AM AN AO AP AQ",
                "AQ AS AT AU AV AW AX AY AZ BA BB BC BD BE BF BG BH",
                "BH BJ BK BL BM BN BO BP BQ BR BS BT BU BV BW BX BY",
                "BY BZ CB CC CD CE CF CG CH CI CJ CK CL CM CN CO CP",
                "CA CP CQ CR CS CT CU CV CW CX CY CZ QQ Q WW"
        };
        String filePath = "block5/ErdosNumber/test.txt";
        List<String> publications11 =  new  LinkedList<>();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;

            // Condition check via buffer.readLine() method
            // holding true upto that the while loop runs
            while ((str = buffer.readLine()) != null) {

                publications11.add(str);
            }
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Print the line number here exception occurred
            // using printStackTrace() method
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(new ErdosNumber().calculateNumbers(publications1)));
    }
}
