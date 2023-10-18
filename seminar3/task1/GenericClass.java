package seminar3.task1;

import java.io.InputStream;
import java.io.Serializable;

public class GenericClass <T extends Comparable, V extends InputStream & Serializable, K extends Number>{
    private T t;
    private V v;
    private K k;

    public GenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void info(){
        System.out.printf("T type is: %s, V type is: %s, K type is: %s", t.getClass().getName(), v.getClass().getName(), k.getClass().getName());
    }
}
