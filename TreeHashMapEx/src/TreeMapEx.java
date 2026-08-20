import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {

        Map<String, Integer> ages = new TreeMap<>();

        ages.put("Karen", 25);
        ages.put("Aram", 20);
        ages.put("Anna", 18);

        System.out.println(ages);
    }
}