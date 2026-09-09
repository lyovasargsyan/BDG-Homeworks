import java.util.Arrays;
import java.util.List;

public class SortNumbers {
    static void main() {
        List<Integer> numbers = Arrays.asList(50, 10, 30, 5, 20);
        numbers.sort((a, b) -> a - b);
        numbers.sort((a, b) -> b - a);
    }
}
