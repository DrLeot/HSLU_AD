package ch.hslu.ad.Fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest{


    @Test
    public void testNegative(){
        assertEquals(0,Fibonacci.fiboRec1(-10));
    }

    @Test
    public void testZero(){
        assertEquals(0,Fibonacci.fiboRec1(0));
    }

    @Test
    public void testOne(){
        assertEquals(1,Fibonacci.fiboRec1(1));
    }

    @Test
    public void testUsual(){
        assertEquals(610,Fibonacci.fiboRec1(15));
    }

    @Test
    public void testFiboRec2(){
        Fibonacci.fiboRec2(6);
        assertEquals("{2=1, 3=2, 4=3, 5=5, 6=8}",Fibonacci.getFibonacciItems().toString());
    }

    @Test
    public void testFiboIterZero() {
        assertEquals(Fibonacci.fiboRec1(0), Fibonacci.fiboIter(0));
    }

    @Test
    public void testFiboIterOne() {
        assertEquals(Fibonacci.fiboRec1(1), Fibonacci.fiboIter(1));
    }

    @Test
    public void testFiboIter(){
        assertEquals(Fibonacci.fiboRec1(9),Fibonacci.fiboIter(9));
    }

}