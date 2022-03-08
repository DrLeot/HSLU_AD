package ch.hslu.ad.Lists.BinaryTree;

public class BinaryTree implements TreeInterface{

    private static int ORDER_LIMIT = 2;
    private Node root = null;

    public BinaryTree(){

    }

    @Override
    public boolean add(int element) {
        if(contains(element)){ // already existant
            return false;
        }

        if(root == null){ // first element -> introduce root
            root = new Node(element);
            return true;
        }

        return insert(root, element); // call insert with context-specific node as root

    }

    private boolean insert(Node node, int element){


        if(element > node.getElement()){ // lookat right tree
            if(node.getRight() != null){
                return insert(node.getRight(),element);
            }
            node.linkRight(new Node(element));
            return true;

        }else{ // lookat left tree
            if(node.getLeft() != null){
                return insert(node.getLeft(),element);
            }
            node.linkLeft(new Node(element));
            return true;

        }

    }

    public Node search(int element){
        return searchLocale(root, element);
    }
    private Node searchLocale(Node node, int element){
        if(node == null){ // exactly there or lower should the searched number, but there isnt a node -> not found
            return null;
        }

        if(node.getElement() == element){
            return node;
        }

        if(element > node.getElement()){ // lookat right tree
            return searchLocale(node.getRight(),element);

        }else{ // lookat left tree
            return searchLocale(node.getLeft(),element);
        }
    }


    @Override
    public boolean contains(int element){
        return search(element) != null;
    }

    @Override
    public boolean remove(int element) {
        return false;
    }

}
