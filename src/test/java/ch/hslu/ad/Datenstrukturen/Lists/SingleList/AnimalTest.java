package ch.hslu.ad.Datenstrukturen.Lists.SingleList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {


    @Test
    public void testEquals(){
        Animal Ape = new Animal("Ape");
        Animal Ape2 = new Animal("Ape");
        assertTrue(Ape.equals(Ape));
        assertTrue(Ape.equals(Ape2));
        assertTrue(Ape2.equals(Ape));
    }
}