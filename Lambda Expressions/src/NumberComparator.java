public class NumberComparator {
    static int comp(NumberComparatorInterface numberComparatorInterface, int a, int b){
        return numberComparatorInterface.compare(a, b);
    }

    static void main() {
        System.out.println(comp((a, b) -> Math.max(a, b), 20, 10));
        System.out.println(comp((a, b) -> Math.max(a, b), 30, 50));
    }
}
