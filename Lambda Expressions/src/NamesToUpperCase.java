import java.util.Arrays;
import java.util.List;

public class NamesToUpperCase {
    static void main() {
        List<String> names = Arrays.asList("anna", "john", "bob", "mike");
        names.forEach(name -> {
            System.out.println(name.toUpperCase());
        });
    }
}
