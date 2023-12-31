package lists;

import java.util.Iterator;

public class MyArrayList<E extends Comparable<E>> implements MyList<E>{
    private E[] values;
    private int index;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.index = 0;
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (E[]) new Comparable[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    private void addCapacity(){
        try {
            E[] temp = (E[]) new Comparable[capacity + capacity / 2];
            System.arraycopy(values, 0, temp, 0, values.length);
            values = temp;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add(E element) {
        if(size == capacity){
            addCapacity();
        }
        values[size] = element;
        size++;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = (E[]) new Comparable[capacity - 1];
            System.arraycopy(values, 0, temp, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(values, index + 1, temp, index, amountElementsAfterIndex);
            values = temp;
            size--;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(E element) {
        for (int i = 0; i < values.length; i++) {
            E elem = values[i];
            if(elem.equals(element)) delete(i);
        }

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public E next() {
                return values[index++];
            }
        };
    }
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(values[i]).append(", ");
        }
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
