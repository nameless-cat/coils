package cat.nemeless.coils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K,V>
    implements Map<K,V>
{
    private class Node<T, S>
        implements Map.Entry<T, S>
    {
        private T key;
        private S value;
        private Node<T, S> next;

        public Node(T key, S value, Node<T, S> next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public T getKey()
        {
            return key;
        }

        @Override
        public S getValue()
        {
            return value;
        }

        @Override
        public S setValue(S value)
        {
            return this.value = value;
        }
    }

    private Node<K,V>[] table;

    private int size;


    public SimpleHashMap()
    {
        table = (Node<K, V>[]) new Node[16];
    }

    public SimpleHashMap(int size)
    {
        this.table = (Node<K, V>[]) new Node[size];
    }

    private int hash(Object key)
    {
        return 0;
    }

    private int indexFor(int hash)
    {
        return 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public boolean containsKey(Object key)
    {
        return false;
    }

    public boolean containsValue(Object value)
    {
        return false;
    }

    public V get(Object key)
    {
        return null;
    }

    public V put(K key, V value)
    {
        if (key == null)
            return putForNullKey(value);

        int pos = indexFor(hash(key.hashCode()));
        Node<K,V> node = table[pos];

        if (node == null)
        {
            table[pos] = new Node<K,V>(key, value, null);
            return value;
        }

        // идем по списку в ячейке, проверяя на совпадение ключей
        while (node != null)
        {
            if (key.equals(node.key))
            {
                node.setValue(value);
                node = node.next;
            }
        }
        // если элемент не найден, вставляем в начало списка
        table[pos] = new Node<>(key, value, table[pos]);

        return value;
    }

    private V putForNullKey(V value)
    {
        return null;
    }

    public V remove(Object key)
    {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m)
    {

    }

    public void clear()
    {

    }

    public Set<K> keySet()
    {
        return null;
    }

    public Collection<V> values()
    {
        return null;
    }

    public Set<Entry<K, V>> entrySet()
    {
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(524288 ^ (524288 >>> 16));
    }
}
