package part1.solution;

interface Set<E> {
    boolean add(E e);

    boolean contains(Object o);
}

interface AbstractTreeSet<E> extends Set<E>{
    E ceiling(E e);

    E floor(E e);
}

class TreeSet<E> implements AbstractTreeSet<E> {

    @Override
    public boolean add(E e) {
        // Implement this method
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // Implement this method
        return false;
    }

    @Override
    public E ceiling(E e) {
        // Implement this method
        return null;
    }

    @Override
    public E floor(E e) {
        // Implement this method
        return null;
    }
}

class HashSet<E> implements Set<E> {

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

}