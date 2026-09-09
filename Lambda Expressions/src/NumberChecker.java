public class NumberChecker {
    static boolean num(NumberCheckerInterface numberCheckerInterface, int number){
        return numberCheckerInterface.check(number);
    }
    public static void main(String[] args){
        System.out.println(num((number) -> number % 2 == 0, 15));
        System.out.println(num((number) -> number % 2 == 0, 7));
        System.out.println(num((number) -> number % 2 == 0, 20));
    }
}
