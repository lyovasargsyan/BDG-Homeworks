public class Box<T>{
        T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }


    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(100);
        Box<String> stringBox = new Box<>("Hello");
        Box<Double> doubleBox = new Box<>(15.5);
        System.out.println(integerBox.getValue());
        System.out.println(stringBox.getValue());
        System.out.println(doubleBox.getValue());
    }
}
