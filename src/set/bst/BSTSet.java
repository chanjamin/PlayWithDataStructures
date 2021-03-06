package set.bst;

import set.Set;
import tree.BST;

public class BSTSet<E extends Comparable<E>> implements Set {
    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(Object o) {
        bst.add((E) o);
    }

    @Override
    public boolean contains(Object o) {
        return bst.contains((E) o);
    }

    @Override
    public void remove(Object o) {
        bst.remove((E) o);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
