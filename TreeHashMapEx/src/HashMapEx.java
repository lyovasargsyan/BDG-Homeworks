import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
    public static void main(String[] args) {

        Map<String, Integer> ages = new HashMap<>();

        ages.put("Aram", 20);
        ages.put("Anna", 18);
        ages.put("Karen", 25);

        System.out.println(ages.get("Aram"));

        ages.put("Aram", 21);

        System.out.println(ages.containsKey("Anna"));

        ages.remove("Karen");

        System.out.println(ages);
    }
}
