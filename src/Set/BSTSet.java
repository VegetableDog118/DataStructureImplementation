package Set;

import BST.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E>  {

    private BST<E> set;

    public BSTSet() {
        this.set = new BST<E>();
    }

    @Override
    public void add(E e) {
        set.add(e);

    }

    @Override
    public void remove(E e) {
        set.remove(e);

    }

    @Override
    public boolean contains(E e) {
        return set.contains(e);

    }

    @Override
    public int getSize() {
        return set.getSize();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }
}
