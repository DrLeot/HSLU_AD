package ch.hslu.ad.Lists.Performance;

import ch.hslu.ad.Lists.Stack.ArrayStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Stack;

public class Demo {

    private static final Logger LOGGER = LogManager.getLogger(Demo.class);
    private static final int AMOUNT = 100000;

    public static void main(String[] args){
        LOGGER.debug("**** ARRAY ****");
        long start = System.nanoTime();
        itemsArray(AMOUNT);
        long end = System.nanoTime();
        LOGGER.debug(end-start+"ns");

        LOGGER.debug("**** STACK ****");
        start = System.nanoTime();
        itemStack(AMOUNT);
        end = System.nanoTime();
        LOGGER.debug(end-start+"ns");

        LOGGER.debug("**** STUD STACK ****");
        start = System.nanoTime();
        itemArrayStack(AMOUNT);
        end = System.nanoTime();
        LOGGER.debug(end-start+"ns");

        LOGGER.debug("**** ARRAYDEQUE ****");
        start = System.nanoTime();
        itemArrayDeque(AMOUNT);
        end = System.nanoTime();
        LOGGER.debug(end-start+"ns");
    }

    public static Item[] itemsArray(int n){
        Item[] items = new Item[n];
        for(int i = 0; i < n;i++){
            items[i] = new Item();
        }


        return items;
    }

    public static Stack<Item> itemStack(int n){
        Stack<Item> stack = new Stack<>();
        stack.setSize(n);
        for(int i = 0; i < n;i++){
            stack.push(new Item());
        }
        return stack;
    }

    public static ArrayStack<Item> itemArrayStack(int n){
        ArrayStack<Item> stack = new ArrayStack<>(n);

        for(int i = 0; i < n;i++){
            stack.push(new Item());
        }
        return stack;

    }

    public static ArrayDeque<Item> itemArrayDeque(int n){
        ArrayDeque<Item> arrayDeque = new ArrayDeque<>(n);

        for(int i = 0; i < n;i++){
            arrayDeque.push(new Item());
        }
        return arrayDeque;
    }
}
