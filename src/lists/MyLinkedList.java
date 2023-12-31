package lists;

import java.util.Iterator;

public class MyLinkedList<E extends Comparable <E>> implements MyList<E>{
    private int size;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public MyLinkedList() {
        this.size = 0;
        this.lastNode = new Node<E>(null, null, firstNode);
        this.firstNode = new Node<E>(null, lastNode, null);
        lastNode.setPrevNode(firstNode);
    }
    private Node<E> getNode(int index){
        Node<E> temp = firstNode.getNextNode();
        for (int i = 0; i < index; i++) {
            temp = temp.getNextNode();
        }
        return temp;
    }

    @Override
    public void add(E element) {
        Node<E> newNode = lastNode;
        newNode.setValue(element);
        lastNode = new Node<E>(null, null, newNode);
        newNode.setNextNode(lastNode);
        size++;
    }
    public void addFirst(E element){
        Node<E> newNode = firstNode;
        newNode.setValue(element);
        firstNode = new Node<E>(null, newNode, null);
        newNode.setPrevNode(firstNode);
        size++;
    }

    @Override
    public void delete(int index) {
        Node<E> nodeToDelete = getNode(index);
        Node<E> prevNode = nodeToDelete.getPrevNode();
        Node<E> nextNode = nodeToDelete.getNextNode();
        if(index == size) prevNode.setNextNode(null);
        else prevNode.setNextNode(nextNode);
        if(index == 0) nextNode.setPrevNode(null);
        else nextNode.setPrevNode(prevNode);
        size--;
    }

    @Override
    public void delete(E element) {
        for (int i = 0; i < size; i++) {
            if(getNode(i).getValue().equals(element)){
                delete(i);
                size--;
            }
        }
    }

    @Override
    public E get(int index) {
        return getNode(index).getValue();
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return (index < size);
            }

            @Override
            public E next() {
                return getNode(index++).getValue();
            }
        };
    }


    private static class Node<E> {
        private E value;
        private Node<E> nextNode;
        private Node<E> prevNode;

        private Node(E value, Node<E> nextNode, Node<E> prevNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
        public Node<E> getNextNode() {
            return nextNode;
        }
        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
        public Node<E> getPrevNode() {
            return prevNode;
        }
        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }
    }
}
