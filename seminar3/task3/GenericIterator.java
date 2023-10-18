package seminar3.task3;

import java.util.Iterator;

public class GenericIterator<T> implements Iterator<T>, Iterable<T> {
    private T[] arr;
    private int idx = 0;

    GenericIterator(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext(){
        return (arr.length > idx);
    }

    @Override
    public T next(){
        if (hasNext()){
            return arr[idx++];
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericIterator<>(arr);
    }
}
