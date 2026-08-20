public class MyArrayList<T>{
    private Object[] data;
    private int size;
    public MyArrayList(){
        data = new Object[10];
        size = 0;
    }
    public void add(T element){
        if (size == data.length){
            resize();
        }
        data[size] = element;
        size++;
    }
    public T get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }
    public int size(){
        return size;
    }
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
    private void resize(){
        Object[] newData = new Object[data.length * 2];

        for(int i = 0; i<data.length; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}