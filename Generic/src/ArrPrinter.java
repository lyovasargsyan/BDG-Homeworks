public class ArrPrinter {
    public static <T> void printArray(T[] array){
        for(T t: array){
            System.out.print(t + ", ");
        }
    }
    public static void main(String[] args){
        Integer[] numbers = {1, 5, 10, 20};
        printArray(numbers);
        System.out.println();

        String[] names = {"Anna", "John", "Bob"};
        printArray(names);
        System.out.println();
    }
}
