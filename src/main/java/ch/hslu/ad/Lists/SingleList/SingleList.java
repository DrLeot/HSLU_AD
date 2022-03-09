package ch.hslu.ad.Lists.SingleList;

import java.util.ArrayList;

public class SingleList {

    private int size = 0;
    private Node head;


    public SingleList(){
        this.head = new Node(null);
    }

    public void add(Animal animal){
        // add at first place. Benefit: We dont need to loop though all nodes
        Node node = new Node(animal);
        node.link(head);
        head = node;
        size++;
    }

    /**
     * possitibilities:
     *  - list is empty (1)
     *  - remove middled-item (3)
     *  - remove HEAD (2)
     *  - remove TAIL (4)
     * @param animal
     * @return
     */
    public boolean remove(Animal animal){

        if(isEmpty()){
            return false;
        }

        Node current = head;
        Node prev = head;

        // HEAD
        if(current.getElement().equals(animal)){
            pop();
            return true;
        }

        while(current.hasNext()) {
            current = current.getNext();
            if(animal.equals(current.getElement())) {
                prev.link(current.getNext());
                size--;
                return true;
            }
            prev = current;
        }

        return false;
    }

    public void clear(){
        this.head = new Node(null);
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0 || head.getElement() == null;
    }

    // returns the first element and removes from list (ex 2.3 (e) )
    public Animal pop(){
        Animal animal = head.getElement();
        head = head.getNext();
        size--;

        return animal;
    }

    public boolean contains(Animal animal){
        if(isEmpty()){
            return false;
        }

        Node current = head;
        if(current.getElement().equals(animal)){
            return true;
        }

        while(current.hasNext()){
            if (current.getNext().getElement().equals(animal)){
                return true;
            }
            current = current.getNext();
        }

        return false;
    }
}
