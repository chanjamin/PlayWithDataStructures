package tree;

import java.util.TreeMap;

public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node() {
            this(false, new TreeMap());
        }

        public Node(boolean isWord, TreeMap next) {
            this.isWord = isWord;
            this.next = next;
        }

        public Node(boolean isWord) {
            this(isWord, null);
        }
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        if (cur.isWord) {
            return true;
        }
        return false;
    }

    public void delete(String word) {
        if (contains(word))
            delete(root, word, 0);
    }

    private void delete(Node node, String word, int index) {
    }

    private void addR(Node node, String word, int index) {
        if (!(index > word.length())) {
            if (node.next.get(word.charAt(index)) == null) {
                Node newNode = new Node();
                node.next.put(word.charAt(index), newNode);
                addR(newNode, word, ++index);
            } else {
                if (index == word.length() - 1 && node.next.get(word.charAt(index)).isWord == true) {
                    size++;
                } else
                    addR(node.next.get(word.charAt(index)), word, ++index);
            }
        }
    }
}
