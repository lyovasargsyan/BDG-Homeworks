public class inheritance {
    public static void main(String[] args) {
        Child child = new Child();
        child.showMessage();

        SubClass subClass = new SubClass();
        subClass.showmessage();

        Truck truck = new Truck(3, "Diesel", 1000);
        System.out.println("Passenger Count: " + truck.getPassengerCount());
        System.out.println("Capacity: " + truck.getCapacity());
        System.out.println("Engine Type: " + truck.getEngineType());
    }
}

class Parent{
    /**
     * Displays a message indicating that this is the parent class.
     */
    void showMessage(){
        System.out.println("Hello parent class.");
    }
}
class Child extends Parent{
    /**
     * Displays a message indicating that this is the child class, and also calls the parent class's showMessage method.
     */
    @Override
    void showMessage(){
        super.showMessage();
        System.out.println("Hello child class.");
    }
}

class SuperClass{
    String message = "Hello SuperClass class";
}

class SubClass extends SuperClass{
    String message = "Hello SubClass class";
    /**
     * Displays the message of the SubClass and the message of the SuperClass.
     */
    public void showmessage(){
        System.out.println(message);
        System.out.println(super.message);
    }
}

class Car{
    int passengerCount;
    String engineType;
    /**
     * Constructs a new Car object with the specified passenger count and engine type.
     * @param passengerCount the number of passengers the car can accommodate
     * @param engineType the type of engine in the car
     * @throws IllegalArgumentException if the passenger count is less than 2
     */
    Car(int passengerCount, String engineType){
        if(passengerCount < 2){
            throw new IllegalArgumentException("Passenger count cannot be smaller than 2.");
        }else{
            this.passengerCount = passengerCount;
        }
        this.engineType = engineType;
    }
    /**
     * Returns the number of passengers the car can accommodate.
     * @return the passenger count
     */
    public int getPassengerCount(){
        return this.passengerCount;
    }
    /**
     * Returns the type of engine in the car.
     * @return the engine type
     */
    public String getEngineType(){
        return this.engineType;
    }
    /**
     * Sets the number of passengers the car can accommodate.
     * @param passengerCount the new passenger count
     * @throws IllegalArgumentException if the passenger count is less than 2
     */
    public void setPassengerCount(int passengerCount){
        if(passengerCount < 2){
            throw new IllegalArgumentException("Passenger count cannot be smaller than 2.");
        }else{
            this.passengerCount = passengerCount;
        }
    }
    /**
     * Sets the type of engine in the car.
     * @param engineType the new engine type
     */
    public void setEngineType(String engineType){
        this.engineType = engineType;
    }
}

class Truck extends Car{
    int capacity;
    /**
     * Constructs a new Truck object with the specified passenger count, engine type, and capacity.
     * @param passengerCount the number of passengers the truck can accommodate
     * @param engineType the type of engine in the truck
     * @param capacity the cargo capacity of the truck (default is 0)
     */
    Truck(int passengerCount, String engineType, int capacity = 0){
        super(passengerCount, engineType);
        this.capacity = capacity;
    }
    /**
     * Returns the number of passengers the truck can accommodate.
     * @return the passenger count
     */
    public int getPassengerCount(){
        return super.getPassengerCount();
    }
    /**
     * Returns the type of engine in the truck.
     * @return the engine type
     */
    public String getEngineType(){
        return super.getEngineType();
    }
    /**
     * Returns the capacity of the truck.
     * @return the capacity
     */
    public int getCapacity(){
        return this.capacity;
    }
    /**
     * Sets the capacity of the truck.
     * @param capacity the new capacity
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
