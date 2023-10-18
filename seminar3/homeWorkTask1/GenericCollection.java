package seminar3.homeWorkTask1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericCollection<T> {
    Object[] arr;

    OwnIterator ownIterator;
    GenericCollection() {
        arr = new Object[0];
    }

    public void add(T t){
        Object[] temp_arr = new Object[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            temp_arr[i] = arr[i];
        }
        temp_arr[temp_arr.length-1] = t;

        arr = new Object[temp_arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp_arr[i];
        }
    }

    public int find(T t){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(t)) return i;
        }
        return  -1;
    }

    public void remove(T t){
        int idx = find(t);
        if (idx > -1){
            ArrayList<Object> arrayList = new ArrayList<>(Arrays.asList(arr));
            arrayList.remove(idx);
            arr = new Object[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arrayList.get(i);
            }
        }
    }

    public String info(){
        return Arrays.toString(arr);
    }

    public OwnIterator getIterator(){
        return ownIterator = new OwnIterator();
    }


    public class OwnIterator{
        private int idx = -1;

        public boolean hasNext(){
            if (arr.length > ++idx) return true;
            return false;
        }

        public T next(){
            if (arr.length > idx) return (T) arr[idx];
            return null;
        }
    }
}
