package lists;

public interface MyList<T extends Comparable<T>> extends Iterable<T>{
    void add(T element);
    void delete(int index);
    void delete(T element);
    T get(int index);
    int size();
}
