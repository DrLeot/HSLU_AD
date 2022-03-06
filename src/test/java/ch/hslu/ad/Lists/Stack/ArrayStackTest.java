package ch.hslu.ad.Lists.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {


    @Test
    public void testArrayStackEmpty(){
        ArrayStack arrayStack = new ArrayStack(100);
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testArrayStackFull(){
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push("a");
        arrayStack.push("b");
        assertTrue(arrayStack.isFull());
    }

    @Test
    public void testPopUsual(){
        ArrayStack arrayStack = new ArrayStack(100);
        arrayStack.push("Nachname");
        arrayStack.push("Vorname");
        arrayStack.push("Hallo");
        assertEquals("Hallo", arrayStack.pop());
    }

    @Test
    public void testPopUsualTwice(){
        ArrayStack arrayStack = new ArrayStack(100);
        arrayStack.push("Nachname");
        arrayStack.push("Vorname");
        arrayStack.push("Hallo");
        arrayStack.pop();
        assertEquals("Vorname", arrayStack.pop());
    }
}