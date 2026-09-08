import java.util.ArrayList;

public class MyList<T>{
    ArrayList<T> arrayList = new ArrayList<>();
    void add(T element){
        arrayList.add(element);
    }

    T get(int index){
        return arrayList.get(index);
    }

    int size(){
        return arrayList.size();
    }
}
