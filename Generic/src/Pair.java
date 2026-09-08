public class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> agePair = new Pair<>("Age", 25);
        Pair<String, String> namePair = new Pair<>("Name", "Tigran");


        System.out.println(agePair.getKey() + ": " +  agePair.getValue());
        System.out.println(namePair.getKey() + ": " + namePair.getValue());
    }

}
