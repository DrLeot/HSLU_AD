package ch.hslu.ad.Algorithmen.Heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {


    @Test
    public void testSingleInsert(){
        FixedSizeHeap<Integer> fixedSizeHeap = new FixedSizeHeap<>(10);
        fixedSizeHeap.insert(15);
        assertEquals("[15, null, null, null, null, null, null, null, null, null]",fixedSizeHeap.toString());
    }

    @Test
    public void testMultipleInsert(){
        FixedSizeHeap<Integer> fixedSizeHeap = new FixedSizeHeap<>(15);
        fixedSizeHeap.insertArray(new Integer[]{17,10,15,5,9,13,12,4,2,1,3,8});
        assertEquals("[17, 10, 15, 5, 9, 13, 12, 4, 2, 1, 3, 8, null, null, null]",fixedSizeHeap.toString());

    }

    @Test
    public void testgetMax(){
        FixedSizeHeap<Integer> fixedSizeHeap = new FixedSizeHeap<>(15);
        fixedSizeHeap.insertArray(new Integer[]{17,10,15,5,9,13,12,4,2,1,3,8});
        assertEquals(17,fixedSizeHeap.getMax());
    }

    @Test
    public void testgetMaxMultipleTimes(){
        FixedSizeHeap<Integer> fixedSizeHeap = new FixedSizeHeap<>(15);
        fixedSizeHeap.insertArray(new Integer[]{17,10,15,5,9,13,12,4,2,1,3,8,14,11,16});
        System.out.println(fixedSizeHeap.toString());
        fixedSizeHeap.getMax();
        System.out.println(fixedSizeHeap.toString());
        assertEquals(13,fixedSizeHeap.getMax());
    }
}