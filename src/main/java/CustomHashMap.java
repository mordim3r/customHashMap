import java.security.Key;


public class CustomHashMap<K, V> {
    int capacity = 16;
    Node<K, V>[] table;

    public CustomHashMap() {
        table = new Node[capacity];
    }

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int index(K key) {
        int hash;
        if (key == null) {
            hash = 0;
        } else {
            hash = Math.abs(key.hashCode());
        }
        return hash % capacity;
    }

    public V put(K key, V value) {
        int i = index(key);
        if (table[i] == null) {
            Node<K, V> node = new Node<>(key, value, null);
            table[i] = node;
            return null;
        } else {
            Node<K, V> current = table[i];
            while (current != null) {
                boolean sameKey;
                if (key == null) {
                    sameKey = (current.key == null);
                } else {
                    sameKey = key.equals(current.key);
                }
                if (sameKey) {
                    V oldValue = current.value;
                    current.value = value;
                    return oldValue;
                } else {
                    current = current.next;
                }
            }
            Node<K, V> newNode = new Node<>(key, value, table[i]);
            table[i] = newNode;
            return null;
        }
    }

    public V get(K key) {
        int i = index(key);
        Node<K, V> current = table[i];
        while (current != null) {
            boolean sameKey;
            if (key == null) {
                sameKey = (current.key == null);
            } else {
                sameKey = key.equals(current.key);
            }
            if (sameKey) {
                return current.value;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public V remove(K key) {
        int i = index(key);
        Node<K, V> current = table[i];
        Node<K, V> prev = null;
        while (current != null) {
            boolean sameKey;
            if (key == null) {
                sameKey = (current.key == null);
            } else {
                sameKey = key.equals(current.key);
            }
            if (sameKey) {
                V oldValue = current.value;
                if (prev == null) {
                    table[i] = current.next;
                } else {
                    prev.next = current.next;
                }
                return oldValue;
            } else {
                prev = current;
                current = current.next;
            }

        }
        return null;
    }
}
