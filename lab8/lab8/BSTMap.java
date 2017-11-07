package lab8;

import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

import java.lang.Exception;

/**
 * Created by cyoste on 2017/08/07.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {

        private Node left;
        private Node right;
        private int size;
        private K key;
        private V value;

        public Node(K k, V v) {
            key = k;
            value = v;
            left = null;
            right = null;
            size = 0;
        }

        public K getKey() {
            return key;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
        public V getValue() {
            return value;
        }
    }
    private Node root;

    public BSTMap(K k, V v) {
        root = new Node(k,v);
    }

    /** Removes all of the mappings from this map. */
    @Override
    void clear() {

    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    boolean containsKey(K key) {

    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    V get(K key) {
        Node traverse = root;
        if (key.equals(root.getKey())) {
            return traverse.getValue();
        }
        else if(key.compareTo(root.getKey()) < 0) {
            
        }
    }

    V get (Node n, K key) {

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    int size() {

    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    void put(K key, V value) {

    }

    /* Returns a Set view of the keys contained in this map. */
    @Override
    Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    V remove(K key) {

    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super K> action) {

    }

    @Override
    public Spliterator<K> spliterator() {
        return null;
    }
}
