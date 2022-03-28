package ch.hslu.ad.Datenstrukturen.Lists.RingBufferQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferQueueGenericTest {

    private RingBufferQueueGeneric<Character> ringBufferQueueGenericCharacter;
    private RingBufferQueueGeneric<Integer> ringBufferQueueGenericInteger;

    @BeforeEach
    public void setup(){
        ringBufferQueueGenericCharacter = new RingBufferQueueGeneric<Character>(10);
        ringBufferQueueGenericInteger = new RingBufferQueueGeneric<Integer>(10);
    }

    @Test
    public void TestCharInsertToEmpty(){
        ringBufferQueueGenericCharacter.enqueue('A');
        ringBufferQueueGenericCharacter.enqueue('B');
        ringBufferQueueGenericCharacter.enqueue('C');
        assertEquals(3, ringBufferQueueGenericCharacter.getUsedSize());
    }
    @Test
    public void TestIntegerInsertToEmpty(){
        ringBufferQueueGenericInteger.enqueue(1);
        ringBufferQueueGenericInteger.enqueue(2);
        ringBufferQueueGenericInteger.enqueue(3);
        assertEquals(3, ringBufferQueueGenericInteger.getUsedSize());
    }


    @Test
    public void testCharDequeueOnce(){
        ringBufferQueueGenericCharacter.enqueue('A');
        ringBufferQueueGenericCharacter.enqueue('B');
        ringBufferQueueGenericCharacter.enqueue('C');
        assertEquals('A', ringBufferQueueGenericCharacter.dequeue());
    }

    @Test
    public void testCharDequeueTwice(){
        ringBufferQueueGenericCharacter.enqueue('A');
        ringBufferQueueGenericCharacter.enqueue('B');
        ringBufferQueueGenericCharacter.enqueue('C');
        ringBufferQueueGenericCharacter.dequeue();
        assertEquals('B', ringBufferQueueGenericCharacter.dequeue());
    }
}