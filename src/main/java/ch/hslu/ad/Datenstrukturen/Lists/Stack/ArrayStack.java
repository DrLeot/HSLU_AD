package ch.hslu.ad.Datenstrukturen.Lists.Stack;

public class ArrayStack<T> implements Stack<T>{

    private int index = 0;
    private final T[] stack;

    public ArrayStack(int size){
        this.stack = (T[]) new Object[size];
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean isFull() {
        return index == stack.length;
    }

    @Override
    public boolean push(T element) {
        if(isFull()){
            return false; // Stack is full
        }
        stack[index] = element;
        index += 1;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
        index -= 1;
        T element = stack[index];
        stack[index] = null;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }

        return stack[index--];
    }
}
