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
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        int index = indexKey(key);
        if (Objects.nonNull(table[index])) {
            return false;
        }
        table[index] = new MapEntry<>(key, value);
        count++;
        modCount++;
        return true;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int indexKey(K key) {
        return hash(Objects.hashCode(key)) & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry item : table) {
           if (Objects.nonNull(item)) {
               newTable[indexKey((K) item.key)] = item;
           }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexKey(key);
        return (checkKey(table[index], key)) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexKey(key);
        boolean rsl = false;
        if (checkKey(table[index], key)) {
            table[index] = null;
            count--;
            modCount++;
            rsl =  true;
        }
        return rsl;
    }

    private boolean checkKey(MapEntry<K, V> el, K key) {
        return Objects.nonNull(el)
                && (Objects.hashCode(el.key) == Objects.hashCode(key))
                && (Objects.equals(el.key, key));
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
