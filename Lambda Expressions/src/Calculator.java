public class Calculator {
    static int calc(CalculatorInterface calculatorInterface, int a, int b){
        return calculatorInterface.calculate(a, b);
    }
    public static void main(String[] args){
        System.out.println(calc((a, b) -> a+b,5,7));
        System.out.println(calc((a, b) -> a+b,4,15));
    }
}
