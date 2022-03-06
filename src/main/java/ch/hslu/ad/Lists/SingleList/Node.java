package ch.hslu.ad.Lists.SingleList;

public class Node {

    private final Animal element;
    private Node next;

    public Node(Animal element){
        this.element = element;
    }

    public Animal getElement() {
        return element;
    }

    public void link(Node next){
        this.next = next;
    }


    public boolean hasNext(){
        return this.next != null;
    }
    public Node getNext(){
        return this.next;
    }

}
