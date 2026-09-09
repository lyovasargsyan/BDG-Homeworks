import java.util.Arrays;
import java.util.List;
public class PrintNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 10, 20, 30);
        numbers.forEach(number -> System.out.println(number));
    }
}
