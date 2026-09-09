import java.util.Arrays;
import java.util.List;

public class PrintEvenNumbers {
    public static void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers.forEach(number -> {
            if(number%2==0){
                System.out.println(number);
            }
        });
    }
}
