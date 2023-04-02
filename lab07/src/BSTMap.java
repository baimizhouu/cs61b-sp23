import java.util.Iterator;
import java.util.Set;
public class BSTMap<K extends Comparable<K>, V extends Comparable<V>> implements Map61B<K, V>{
	private BSTMap<K, V> left;
    private BSTMap<K, V> right;
    public K key;
    public V value;
    private int size;
    public BSTMap(K key, V Val) {
        int size = 1;
        this.key = key;
        this.value = Val;
        this.left = null;
        this.right = null;
    }
    public BSTMap(){
        int size = 0;
        this.key = null;
        this.value = null;
        this.left = null;
        this.right = null;
    }
    /** Associates the specified value with the specified key in this map.
     *  If the map already contains the specified key, replaces the key's mapping
     *  with the value specified. */
    public void put(K key, V value){
        if(this.value == null){
            this.key = key;
            this.value = value;
            size++;
            return;
        }
        putHelper(this, key, value, this);
    }
    private BSTMap<K, V> putHelper(BSTMap<K, V> T, K key, V value, BSTMap<K, V> save){
        if(T == null){
            save.size++;
            return new BSTMap<K, V>(key, value);
        }
        if(key.compareTo((K)T.key) < 0) {
            T.left = putHelper(T.left, key, value, save);
        } else if (key.compareTo((K)T.key) > 0) {
            T.right = putHelper(T.right, key, value, save);
        }
        return T;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. */
    public V get(K key){
        return getHelper(this,key);
    }
    private V getHelper(BSTMap<K, V> T, K key){
        if(T == null){
            return null;
        }
        if(T.key == null){
            return null;
        }
        if(key.compareTo(T.key) == 0){
            return T.value;
        }
        if(key.compareTo(T.key) > 0){
            return getHelper(T.right , key);
        } else if (key.compareTo(T.key) < 0) {
            return getHelper(T.left, key);
        }
        return null;
    }

    /** Returns whether this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        return containsKeyHelper(this,key);
    }
    private boolean containsKeyHelper(BSTMap<K, V> T, K key){
        if(T.key == null){
            return false;
        }
        if(T == null){
            return false;
        }
        if(key.compareTo(T.key) > 0){
            return containsKeyHelper(T.right, key);
        }else if(key.compareTo(T.key) < 0){
            return containsKeyHelper(T.left, key);
        } else if (key.compareTo(T.key) == 0) {
            return true;
        }
        return true;
    }


    /** Returns the number of key-value mappings in this map. */
    public int size(){
        return this.size;
    }

    /** Removes every mapping from this map. */
    public void clear(){
        this.value = null;
        this.key = null;
        this.left = null;
        this.right = null;
        this.size = 0;
    }


    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }

    /** Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
    /*public static void main(String[] args) {
        BSTMap test = new BSTMap<Integer, Integer>(1,2);
    }*/
}