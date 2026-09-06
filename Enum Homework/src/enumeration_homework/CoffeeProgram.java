package enumeration_homework;

public class CoffeeProgram {
    public static void main(String[] args){
        for(CoffeeSize coffeeSize: CoffeeSize.values()){
            System.out.println("Name: " + coffeeSize.name() + " Ordinal: " + coffeeSize.ordinal());
        }
    }
}
