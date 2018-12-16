import java.io.Serializable;
/**
 * LinkedList generic class that helps maintain sections and paragraphs
 *
 * @author Oyunomin Munkhkhurel
 * @version 2018/02/03
 */
public class LinkedList<E> implements Serializable {
    private Node<E> front;
    private Node<E> end;
    
    public LinkedList() {
        front = null;
        end = null;
    }
    
    /*
     * Inserts the specified element at the specified position in this list.
     *
     * @param  E element desired element to be added
     * @param  int index desired index
     */
    public void add(int index, E element) {
        ensure(element);
        if(index == 0) {
            addFirst(element);
        } else if(index == size()) {
            addLast(element);
        } else {
            int count = 0;
            Node<E> current = front;
            Node<E> newNode = new Node<E>(element);
            while (current != null) {
                current = current.next;
                count++;
                if (count == index) {
                    newNode.prev = current.prev;
                    newNode.next = current;
                    current.prev = newNode;
                    newNode.prev.next = newNode;
                }
            }
        }
    }
    
    /*
     * Inserts the specified element at the beginning of this list.
     *
     * @param  E element desired element to be added
     */
    public void addFirst(E element){
        ensure(element);
        Node<E> newNode = new Node<E>(element);
        if (front == null && end == null) {
            front = newNode;
            end = newNode;
        } else {
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
        } 
    }
    
    /*
     * Appends the specified element to the end of this list.
     *
     * @param  E element desired element to be added
     */
    public void addLast(E element) {
        ensure(element);
        Node<E> newNode = new Node<E>(element);
        if (front == null && end == null) {
            addFirst(element);
        } else {
            Node<E> current = front;
            while(current.next != null) {
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = current.next;
            current.next = newNode;
            end = newNode;
        } 
    }
        
    
    // /*
     // * Returns true if this list contains the specified element.
     // *
     // * @param  E element that is checking if it is in the list
     // * @return   true if list contains element, if not, false
     // */
    // public boolean contains(E element) {
        // ensure(element);
        // boolean tempo = false;
            // if (front == null && end == null) {
                // //do nothing 
            // } else {
                // Node<E> current = front;
                // while(current.next != null) {
                // current = current.next;
                    // if (current.data.equals(element)) {
                        // tempo = true;
                    // } else {
                    // tempo = false;
                // }
            // }
        // }
        // return tempo;
    // }
    
    /*
     * Returns the first element in this list.
     *
     * @return   first element in this list
     */
    private E getFirst() {
        E tempo = null;
        if (front == null && end == null) {
            //do nothing, list is empty
        } else {
            Node<E> current = front;
            tempo = current.data;
        }
        return tempo;
    }
    
    /*
     * Returns the last element in this list.
     *
     * @return   last element in this list
     */
    private E getLast() {
        E tempo = null;
        if (front == null && end == null) {
            //do nothing, list is empty
        } else {
            Node<E> current = end;
            tempo = current.data;
        }
        return tempo;
    }
    
    /*
     * Retrieves the element by desired index
     * 
     * @param int index desired element's index
     * @return element on that index
     */
    public E get(int index) {
        E tempo = null;
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("invalid index, must be smaller than size");
        }
        if (front == null && end == null) {
            //do nothing, list is empty
        } else if (index == 0) {
            tempo = getFirst();
        } else if (index == size() - 1) {
            tempo = getLast();
        } else {
            int count = 0;
            Node<E> current = front;
            while(current != null) {
                current = current.next;
                count++;
                if (count == index) {
                    tempo = current.data;
                }
            }   
        }
        return tempo;
    }
    
    /*
     * Retrieves the position of an specified element 
     *
     * @param  E element desired element to be found
     * @return position of the element represented by integer
     */
    public int getPosition(E element) {
        ensure(element);
        int position = 0;
        if (front.data.equals(element)) {
            //postion = 0; do nothing
        } else {
            Node<E> current = front;
            while(current != null && !current.data.equals(element)) {
                current = current.next;
                position++;
            } 
        }
        return position;
    }
    
    /*
     * Returns the number of elements in this list.
     *
     * @return   the number of elements in this list.
     */
    public int size() {
        int count = 0;
        Node<E> current = front;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
    
    /*
     * Removes the desired element from the list 
     *
     * @param  E element desired element to be removed
     * @return true if successfully removed, if not, false
     */
    public boolean remove(E element) {
        boolean wasRemoved = false;
        ensure(element);
        if (front == null && end == null) {
            //do nothing
        }else if (front.data.equals(element)) {
            front = front.next;
            wasRemoved = true;
        } else {
           Node<E> current = front;
           while(current != null && !current.data.equals(element)) {
                current = current.next;
           }
           if (current != null && current.data.equals(element)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    wasRemoved = true;
           } else {
                // do nothing
           }
        }
        return wasRemoved;
    }
    
    /*
     * Moves desired element up
     * 
     * @param   E element to make up
     */
    public void moveUp(E element) {
        int index = getPosition(element);
        remove(element);
        add(index - 1, element);
    }
    
    /*
     * Moves desired element down
     * 
     * @param   E element to make down
     */
    public void moveDown(E element) {
        int index = getPosition(element);
        remove(element);
        add(index + 1, element);
    }
    
    /*
     * Sets null to the list
     */
    public void clear() {
        front = null;
    }
    
    /*
     * Ensures coming element is not null
     * 
     * @param E element that is being checked
     */
    public void ensure(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }
    }
    
    
    @Override
    /**
     * Retrieves verbal states of the list
     * 
     * @return verbal states of the list
     */
    public String toString() {
        String info = "";
        Node<E> current = front;
        while(current != null) {
            info += current.data + "\n";
            current = current.next;
        }
        return info;
    }
    
    private class Node<E> implements Serializable {
        public Node<E> next; 
        public Node<E> prev;
        public E data;
        public Node(E data){
            this.data = data;
            next = null;
            prev = null;
        }
        
        public String toString() {
            return data + " ";
        }
    }
}
