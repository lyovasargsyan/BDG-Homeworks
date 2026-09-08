import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcard {
    public static void printList(List<?> list){
        for (Object o : list) {
            System.out.print(o);
        }
        System.out.println();
    }
    public static void main(String[] args){
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        printList(integers);

        List<String> strings = new ArrayList<>();
        strings.add("Anna");
        strings.add("Bob");
        strings.add("John");
        printList(strings);

        List<Double> doubles = new ArrayList<>();
        doubles.add(10.5);
        doubles.add(20.5);
        printList(doubles);
    }
}
