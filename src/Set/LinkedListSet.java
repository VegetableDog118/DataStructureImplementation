package Set;

import LinkedList.LinkedList;

public class LinkedListSet<E extends Comparable<E>> implements Set {

    private LinkedList<E> set;

    public LinkedListSet() {
        this.set = new LinkedList();
    }


    @Override
    public void add(Object o) {
        if(set.contains((E)o)){
            return;
        }else{
            set.addFirst((E)o);
        }

    }

    @Override
    public void remove(Object o) {
        set.removeElement((E)o);
    }

    @Override
    public boolean contains(Object o) {
        return set.contains((E)o);
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
