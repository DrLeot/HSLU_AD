package ch.hslu.ad.Datenstrukturen.Lists.Stack;

public interface Stack<T> {
    int size();
    boolean isEmpty();
    boolean isFull();
    boolean push(T element);
    T pop();
    T peek();
}
