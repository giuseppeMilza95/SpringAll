public class GenericClass <K,V> implements GenericInterface<K,V>{
    private final K k;
    private final V v;

    public GenericClass(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public K getKey() {
        return this.k;
    }

    @Override
    public V getValue() {
        return this.v;
    }
}
