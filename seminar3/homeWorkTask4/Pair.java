package seminar3.homeWorkTask4;

public class Pair<N, V> {
    private N n;
    private V v;

    public Pair(N n, V v) {
        this.n = n;
        this.v = v;
    }

    public N getFirst() {
        return n;
    }

    public V getSecond() {
        return v;
    }

    @Override
    public String toString() {
        return "Пара{" +
                "Ключ = " + n +
                ",   Значение = " + v +
                '}';
    }
}
