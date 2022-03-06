package ch.hslu.ad.Lists.Stack;

import ch.hslu.ad.Lists.SingleList.Animal;

public interface Stack {
    int size();
    boolean isEmpty();
    boolean isFull();
    boolean push(String string);
    String pop();
}
