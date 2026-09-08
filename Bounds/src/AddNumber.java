import java.util.ArrayList;
import java.util.List;

public class AddNumber {
    public static void addNumbers(List<? super Integer> list){
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addNumbers(integers);
        addNumbers(numbers);
        addNumbers(objects);
    }
}
