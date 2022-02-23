package ch.hslu.ad.Memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemorySimpleTest {


    @Test
    public void testConstructor(){
        assertEquals(10, new MemorySimple(10).getSize());
    }

    @Test
    public void testToString(){
        assertEquals("MemorySimple[Belegt:0; Frei:10]", new MemorySimple(10).toString());
    }

    @Test
    public void testMemoryUsedToString(){
        MemorySimple memorySimple = new MemorySimple(1024);
        memorySimple.malloc(8);
        assertEquals("MemorySimple[Belegt:8; Frei:1016]", memorySimple.toString());
    }

    @Test
    public void testClear(){
        MemorySimple memorySimple = new MemorySimple(1024);
        memorySimple.malloc(64);
        memorySimple.clear();
        assertEquals(0,memorySimple.getUsedSize());
    }

    @Test
    public void testFree(){
        MemorySimple memorySimple = new MemorySimple(1024);
        Allocation blockA = memorySimple.malloc(3);
        Allocation blockB = memorySimple.malloc(7);
        memorySimple.free(blockA);
        assertEquals(7,memorySimple.getUsedSize());
    }
}