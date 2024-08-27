
import java.util.*;

public class PartySeats {
    public String[] seating(String[] attendees) {
        String[] seating = new String[attendees.length+2];
        String[] emptyResult = new String[attendees.length+2];
        if (attendees.length %2 ==1)
            return Arrays.stream(seating)
                    .filter(s -> (s != null && !s.isEmpty()))
                    .toArray(String[]::new);

        seating[0] = "HOST";
        List<String> boys = new ArrayList<>();
        List<String> girls = new ArrayList<>();
        for (String attendee : attendees) {
            String[] att = attendee.split(" ");
            if (att[1].equals("boy")) {
                boys.add(att[0]);
            } else if (att[1].equals("girl")) {
                girls.add(att[0]);
            }
        }
        Collections.sort(boys);
        Collections.sort(girls);
        if (boys.size() != girls.size())
            return Arrays.stream(emptyResult)
                    .filter(s -> (s != null && !s.isEmpty()))
                    .toArray(String[]::new);;
        Queue<String> boyQueue = new LinkedList<>(boys);
        Queue<String> girlQueue = new LinkedList<>(girls);
        int half = (seating.length) / 2 ;
        for (int i = 0; i < seating.length; i++) {
            if (i == 0){
                seating[i] = "HOST";
            }
            else if (i == half){
                seating[i] = "HOSTESS";
            }
            else {
                //attendee mode
                if (i %2 ==0) {
                    //Boy
                    String name = boyQueue.poll();
                    if (Objects.isNull(name))
                        return Arrays.stream(emptyResult)
                                .filter(s -> (s != null && !s.isEmpty()))
                                .toArray(String[]::new);
                    seating[i] = name;
                } else{
                    String name = girlQueue.poll();
                    if (Objects.isNull(name))
                        return Arrays.stream(emptyResult)
                                .filter(s -> (s != null && !s.isEmpty()))
                                .toArray(String[]::new);
                    seating[i] = name;
                }

            }

        }
        return Arrays.stream(seating)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
    }

}
