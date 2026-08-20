class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
}
public class MyLinkedList<T>{
    private Node<T> head;
    private int size;

    public void add(T element){
        Node<T> newNode = new Node<>(element);
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
    }

    public void add(int index, T element) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(element);

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public int indexOf(T element) {
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

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = element;
    }


}
