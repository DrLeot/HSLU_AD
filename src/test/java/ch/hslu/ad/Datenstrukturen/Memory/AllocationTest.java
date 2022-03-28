package ch.hslu.ad.Datenstrukturen.Memory;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AllocationTest {


    @Test
    public void testConstructorSize(){
        assertEquals(10,new Allocation(10,0).getSize());
    }

    @Test
    public void testConstructorStartAddress(){
        assertEquals(15,new Allocation(10,15).getStartAddress());
    }

    @Test
    public void testhashCode(){
        assertEquals(Objects.hash(10,0), new Allocation(10,0).hashCode());
    }

    @Test
    public void testEquals(){
        EqualsVerifier.forClass(Allocation.class).verify();
    }

    @Test
    public void testToString(){
        assertEquals("Allocation[Address:0; Size:10]",new Allocation(10,0).toString());
    }
}