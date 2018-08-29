package map.linkedlist;

import map.Map;

public class LinkedListMap<K,V> implements Map<K,V> {

    private class Pair<K,V>{
        private K key;
        private V value;
        private Pair next;

        public Pair(K key, V value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Pair(K key){
            this(key,null,null);
        }
        public Pair(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Pair dumbHead;
    private int size;

    public LinkedListMap() {
     dumbHead=new Pair();size=0;
    }

    private Pair getPair(K key){
        Pair cur = dumbHead.next;
        while (cur!=null){
            if (cur.key.equals(key))
                return cur;
            cur=cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Pair pair = getPair(key);
        if (pair != null) {
            pair.value=value;
        }else {
            size++;
            dumbHead.next=new Pair(key,value,dumbHead.next);
        }
    }

    @Override
    public V remove(K key) {
        Pair pair = getPair(key);
        if (pair == null) {
            return null;
        }else {
            Pair ret = pair;
            pair.value=null;
            size--;
            return (V) ret.value;
        }
    }

    @Override
    public boolean contains(K key) {
        return getPair(key)!=null;
    }

    @Override
    public V get(K key) {
        Pair pair = getPair(key);
        return pair==null?null: (V) pair.value;
    }

    @Override
    public void set(K key, V newValue) {
        add(key,newValue);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
