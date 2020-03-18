package day1.part1;

interface Set<E> {
    boolean add(E e);

    boolean contains(Object o);

    E ceiling(E e);

    E floor(E e);
}

class TreeSet implements Set {

    @Override
    public boolean add(Object e) {
        // Implement this method
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // Implement this method
        return false;
    }

    @Override
    public Object ceiling(Object e) {
        // Implement this method
        return null;
    }

    @Override
    public Object floor(Object e) {
        // Implement this method
        return null;
    }
}

class HashSet implements Set {

    @Override
    public boolean add(Object e) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object ceiling(Object e) {
        // This method is not applicable for HashSet
        return null;
    }

    @Override
    public Object floor(Object e) {
        // This method is not applicable for HashSet
        return null;
    }
}