import java.util.*;
public class MyArrayList<T> implements List<T>{
    private Object[] data;
    private int size;

    /**
     * Creates an empty MyArrayList with an initial capacity of 10.
     */
    public MyArrayList(){
        data = new Object[10];
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     * @return
     */
    public boolean add(T element){
        if (size == data.length){
            resize();
        }
        data[size] = element;
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public T get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    /**
     * Returns the number of elements currently in the list.
     *
     * @return the number of elements in the list
     */
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    /**
     * Removes the element at the specified index and shifts
     * subsequent elements to the left.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public T remove(int index){
        if(index<0 || index>= size){
            throw new IndexOutOfBoundsException();
        }
        T removed = (T) data[index];
        for(int i=index; i<size-1;i++){
            data[i] = data[i+1];
        }
        data[size-1]=null;
        size--;
        return removed;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    /**
     * Doubles the capacity of the internal array
     * and copies the existing elements into the new array.
     */
    private void resize(){
        Object[] newData = new Object[data.length * 2];

        for(int i = 0; i<data.length; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {

        MyArrayList<String> aaa = new MyArrayList<>();

        aaa.add("aaaa");
        aaa.add("bbbb");
        aaa.add("ccc");

        System.out.println(aaa.size());

        System.out.println(aaa.get(0));
        System.out.println(aaa.get(1));

        System.out.println(aaa.contains("aaaa"));
        System.out.println(aaa.contains("bbbb"));

        System.out.println(aaa.indexOf("cccc"));

        aaa.add("aaaa");
        System.out.println(aaa.lastIndexOf("aaaa"));

        System.out.println(aaa.remove(0));

        System.out.println(aaa.size());

        System.out.println(aaa.isEmpty());

        aaa.clear();

        System.out.println(aaa.isEmpty());
    }
}
