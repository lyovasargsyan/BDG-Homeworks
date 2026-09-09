import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterNames {
    static void main() {
        List<String> names = new ArrayList<>(Arrays.asList(
                "Anna",
                "Bob",
                "Alexander",
                "John",
                "Andrew"
        ));
        names.removeIf((text) -> text.length()<5);
        System.out.println(names);
    }
}
