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
        if (((float) count / capacity) >= LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(Objects.hashCode(key)));
        if (Objects.nonNull(table[index])) {
            return false;
        }
        table[index] = new MapEntry<>(key, value);
        count++;
        modCount++;
        return true;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> 16));
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        int index;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry item : table) {
           if (Objects.nonNull(item)) {
               index = indexFor(hash(Objects.hashCode(item.key)));
               newTable[index] = new MapEntry<>((K) item.key, (V) item.value);
           }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (Objects.nonNull(table[index])) {
            if (Objects.hashCode(table[index].key) == Objects.hashCode(key)) {
                if (Objects.equals(table[index].key, key)) {
                    return table[index].value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (Objects.nonNull(table[index])) {
            if (Objects.hashCode(table[index].key) == Objects.hashCode(key)) {
                if (Objects.equals(table[index].key, key)) {
                    table[index] = null;
                    count--;
                    modCount++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            private int index = 0;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
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
        NonCollisionMap<Integer, Object> map = new NonCollisionMap<>();
        int hash = map.hash(0);
        hash = map.hash(65536);
        int index = map.indexFor(0);
        index = map.indexFor(7);
        System.out.println(index);
        System.out.println(7 & 7);
    }
}
