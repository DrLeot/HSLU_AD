package ch.hslu.ad.Datenstrukturen.Lists.BinaryTree;

public class Node {

    private final int element;
    private Node left;
    private Node right;

    public Node(int element){
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void linkLeft(Node node){
        this.left = node;
    }

    public void linkRight(Node node){
        this.right = node;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return element + "(" + left + ", " +
                right + ")";
    }
}
