package ch.hslu.ad.Lists.Stack;

public interface Stack {
    int size();
    boolean isEmpty();
    boolean isFull();
    boolean push(String string);
    String pop();
    String peek();
}
