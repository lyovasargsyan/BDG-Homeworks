public class SumOfNumbers {
    public static <T extends Number> double sum(T[] numbers){
        double sum = 0;
        for(T number: numbers){
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args){
        Integer[] numbers = {1, 5, 10, 20};
        System.out.println(sum(numbers));
        Double[] prices = {10.5, 20.5, 5.0};
        System.out.println(sum(prices));
    }
}
