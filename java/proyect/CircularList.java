import java.util.*;

public class CircularList<E> extends LinkedList<E> {
    private int index, capacity;

    public int capacity() {
        return capacity;
    }

    public int getIndex() {
        return index; 
    }

    public void setIndex(int x) {
        if (x >= 0 && x < capacity)
            index = x;
        else      
            index = 0;
    }

    public E getCurrent() {
        return this.get(index);
    }

    public E next() {
        if (++index == capacity)
            index = 0;
        return get(index); 
    }

    public E previous() {
        if (--index < 0)
            index = capacity - 1;
        return get(index);
    }

    public CircularList(int length) {
        super();
        index = -1;
        capacity = length;
        for (int i = 0; i < capacity; i++)
            add(i, null);
    }

    public void enqueue(E element) {
        if (index + 1 == capacity)
            index = -1;
        add(++index, element);
    }

    public E dequeue() throws Exception {
        if (index < 0) 
            throw new Exception("Nunca agregaste elementos -_-");
        E element = get(index--);
        if (index < 0) 
            index = capacity - 1;
        return element;
    }
    public boolean isEmpty(){
        return get(0) == null;
    }    
}