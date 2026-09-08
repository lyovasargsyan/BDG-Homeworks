public class MaximumNumber {
    public static <T extends Number> void printNumber(T number){
        System.out.println(number);
    }
    public static void main(String[] args){
        Integer a = 15;
        printNumber(a);
        Double b = 15.35;
        printNumber(b);
        Long c = 26L;
        printNumber(c);
    }
}
