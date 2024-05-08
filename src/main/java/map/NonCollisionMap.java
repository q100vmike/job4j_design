package map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> 16));
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private Integer[] data;
            private int index;
/*            public iterator(Integer[] data) {
                this.data = data;
            }*/
            @Override
            public boolean hasNext() {
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < data.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++];
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
/*        что вызов метода map.hash(0) вернет 0, вызов map.hash(65535) вернет 65535, а
        вызов map.hash(65536) вернет 65537. Для метода indexFor(int hash) должно быть так:  \
        вызов map.indexFor(0) вернет 0, вызов map.indexFor(7) вернет 7, вызов map.indexFor(8) вернет 0.*/
        NonCollisionMap<Integer, Object> map = new NonCollisionMap<>();
        //Map<User, Object> map = new HashMap<>();
        int hash = map.hash(0);
        hash = map.hash(65536);
        int index = map.indexFor(0);
        index = map.indexFor(7);
        System.out.println(index);
        System.out.println(7 & 7);
    }
}
