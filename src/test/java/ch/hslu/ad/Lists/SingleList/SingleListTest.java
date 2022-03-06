package ch.hslu.ad.Lists.SingleList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SingleListTest {

    private SingleList singleList;

    @BeforeEach
    public void setup(){
        singleList = new SingleList();
    }

    @Test
    public void testNullSize(){
        assertEquals(0,singleList.size());
    }

    @Test
    public void testAddOne(){
        singleList.add(new Animal("Alpha"));
        singleList.add(new Animal("Beta"));
        singleList.add(new Animal("Gamma"));
        assertEquals(3,singleList.size());
    }

    @Test
    public void testSingleItemListContains(){
        Animal animal = new Animal("Gustav");
        singleList.add(animal);
        assertTrue(singleList.contains(animal));
    }

    @Test
    public void testEmptyListContains(){
        Animal animal = new Animal("Gustav");
        assertFalse(singleList.contains(animal));
    }

    @Test
    public void testMultiItemListcontains(){
        Animal animal = new Animal("Alpha");
        singleList.add(animal);
        singleList.add(new Animal("Beta"));
        singleList.add(new Animal("Gamma"));

        assertTrue(singleList.contains(animal));
    }

    @Test
    public void testMultiItemListContains(){
        singleList.add(new Animal("Alpha"));
        Animal animal = new Animal("Beta");
        singleList.add(animal);
        singleList.add(new Animal("Gamma"));
        assertTrue(singleList.contains(animal));

    }

    @Test
    public void testPopGetElement(){
        singleList.add(new Animal("Alpha"));
        singleList.add(new Animal("Beta"));
        Animal animal = new Animal("Gamma");
        singleList.add(animal);

        assertEquals(animal,singleList.pop());
    }

    @Test
    public void testPopSize(){
        singleList.add(new Animal("Alpha"));
        singleList.add(new Animal("Beta"));
        Animal animal = new Animal("Gamma");
        singleList.add(animal);
        singleList.pop();

        assertEquals(2,singleList.size());
    }


    @Test
    public void testRemoveMiddle(){
        singleList.add(new Animal("Alpha"));
        singleList.add(new Animal("Beta"));
        Animal animal = new Animal("Gamma");
        singleList.add(animal);
        singleList.add(new Animal("Delta"));
        assertTrue(singleList.remove(animal));
    }

    @Test
    public void testRemoveLast(){
        Animal animal = new Animal("Alpha");
        singleList.add(animal);
        singleList.add(new Animal("Beta"));
        singleList.add(new Animal("Gamma"));
        singleList.add(new Animal("Delta"));
        assertTrue(singleList.remove(animal));
    }

    @Test
    public void testRemoveFirst(){
        singleList.add(new Animal("Alpha"));
        singleList.add(new Animal("Beta"));
        singleList.add(new Animal("Gamma"));
        Animal animal = new Animal("Delta");
        singleList.add(animal);
        assertTrue(singleList.remove(animal));
    }
}