package ch.hslu.ad.Lists.Stack;

import java.util.ArrayList;

public class ArrayStack implements Stack{

    ArrayList<Integer> a = null;

    private int index = 0;
    private final String[] stack;

    public ArrayStack(int size){
        this.stack = new String[size];
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
    public boolean push(String string) {
        if(isFull()){
            return false; // Stack is full
        }
        stack[index] = string;
        index += 1;
        return true;
    }

    @Override
    public String pop() {
        if(isEmpty()){
            return null;
        }
        index -= 1;
        String string = stack[index];
        stack[index] = null;
        return string;
    }

    @Override
    public String peek() {
        if(isEmpty()){
            return null;
        }

        return stack[index--];
    }
}
