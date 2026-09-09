public class Greeting{
    static void greet(GreetInterface greetInterface){
        greetInterface.sayHello();
    }
    public static void main(String[] args) {
        greet(() -> System.out.println("Hello World"));
    }
}
