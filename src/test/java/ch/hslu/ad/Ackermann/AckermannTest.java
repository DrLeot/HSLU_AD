package ch.hslu.ad.Ackermann;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AckermannTest {


    @Test
    public void testZeroZero(){
        assertEquals(1,Ackermann.ack(0,0));
    }

    @Test
    public void testZeroFour(){
        assertEquals(5,Ackermann.ack(0,4));
    }

    @Test
    public void testFourZero(){
        assertEquals(13,Ackermann.ack(4,0));
    }
}