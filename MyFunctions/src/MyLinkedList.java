import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Node<T>{
    T data;
    Node<T> next;

    /**
     * Creates a new node containing the specified data.
     *
     * @param data the data to store in the node
     */
    Node(T data){
        this.data = data;
    }
}


public class MyLinkedList<T> implements List{
    private Node<T> head;
    private int size;

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     * @return
     */
    public boolean add(Object element){
        Node<T> newNode = new Node(element);
        if(head == null){
            head = newNode;
        }
        else{
            Node<T> current = head;

            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return false;
    }

    /**
     * Adds an element at the specified index.
     *
     * @param index the position at which to add the element
     * @param element the element to add
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void add(int index, Object element) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
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
        Node<T> current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            T removed = head.data;
            head = head.next;
            size--;
            return removed;
        }

        Node<T> last = head;
        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            last = last.next;
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        last.next = current.next;
        size--;

        return current.data;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return List.of();
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the list contains no elements.
     *
     * @return true if the list is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * Checks whether the specified element exists in the list.
     *
     * @param element the element to search for
     * @return true if the element is found, otherwise false
     */
    public boolean contains(Object element) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     *
     * @param element the element to search for
     * @return the index of the element, or -1 if the element is not found
     */
    public int indexOf(Object element) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    /**
     * Replaces the element at the specified index with the given element.
     *
     * @param index   the index of the element to replace
     * @param element the new element
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = (T) element;
        return element;
    }

    public static void main(String[] args) {

        MyLinkedList<String> aaa = new MyLinkedList<>();

        aaa.add("aaaa");
        aaa.add("bbbb");
        aaa.add("ccc");

        System.out.println(aaa.size());

        System.out.println(aaa.get(0));
        System.out.println(aaa.get(1));

        System.out.println(aaa.contains("aaaa"));
        System.out.println(aaa.contains("bbbb"));

        System.out.println(aaa.indexOf("cccc"));

        aaa.add(1, "dddd");
        System.out.println(aaa.get(1));

        System.out.println(aaa.remove(0));

        System.out.println(aaa.size());

        System.out.println(aaa.isEmpty());

        System.out.println(aaa.set(0, "eeee"));
        System.out.println(aaa.get(0));
    }
}
