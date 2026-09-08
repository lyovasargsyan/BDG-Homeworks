public class Printer {
    public static <T> void print(T value){
        System.out.println(value);
    }

    public static void main(String[] args) {
        Integer a = 7;
        String b = "Hello";
        Double c = 15.5;
        Boolean d = true;
        print(a);
        print(b);
        print(c);
        print(d);
    }
}
