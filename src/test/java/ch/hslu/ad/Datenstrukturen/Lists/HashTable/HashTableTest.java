package ch.hslu.ad.Datenstrukturen.Lists.HashTable;

import ch.hslu.ad.Datenstrukturen.DemoClasses.Student;
import ch.hslu.ad.Datenstrukturen.Lists.HashTable.HashTableSimple.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void testIsFull(){
        HashTable hashTable = new HashTable(3);
        hashTable.add(new Student(1,"Tick","Ente"));
        hashTable.add(new Student(2,"Trick","Ente"));
        hashTable.add(new Student(3,"Track","Ente"));
        assertTrue(hashTable.isFull());
    }

    @Test
    public void testIsNotFullAfterRemove(){
        HashTable hashTable = new HashTable(3);
        Student student = new Student(1,"Tick","Ente");
        hashTable.add(student);
        hashTable.add(new Student(2,"Trick","Ente"));
        hashTable.add(new Student(3,"Track","Ente"));
        hashTable.remove(student);
        assertFalse(hashTable.isFull());
    }

    @Test
    public void testIsEmpty(){
        HashTable hashTable = new HashTable(10);
        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testHashTableSimpleInsert(){
        HashTable hashTable = new HashTable(10);
        assertTrue(hashTable.add(new Student(1,"Hans","Künzler")));
    }

    @Test
    public void testHashTableDuplicate(){
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Student(1,"Hans","Künzler"));
        assertFalse(hashTable.add(new Student(1,"fddfs","fdsdsf")));
    }

    @Test
    public void testContains(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(1,"Hans","Künzler");
        hashTable.add(student);
        assertTrue(hashTable.contains(student));
    }

    @Test
    public void testNotContains(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(1,"Hans","Künzler");
        Student student2 = new Student(58,"Darth","Vader");

        hashTable.add(student);
        assertFalse(hashTable.contains(student2));
    }

    @Test
    public void testNotcontainsAfterRemove(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(1,"Hans","Künzler");
        hashTable.add(student);
        hashTable.remove(student);
        assertFalse(hashTable.contains(student));
    }

    @Test
    public void testHashTableInsertWithSondierenOnce(){
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Student(1,"Hans","Künzler"));
        hashTable.add(new Student(11,"Karla","Kolumna"));
        assertEquals("[NULL][NULL][Hans Künzler -> 1][Karla Kolumna -> 11][NULL][NULL][NULL][NULL][NULL][NULL]",hashTable.toString());
    }
    @Test
    public void testHashTableInsertWithSondierenTwice(){
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Student(1,"Hans","Künzler"));
        hashTable.add(new Student(11,"Karla","Kolumna"));
        hashTable.add(new Student(21,"Benjamin","Blümchen"));
        assertEquals("[NULL][NULL][Hans Künzler -> 1][Karla Kolumna -> 11][Benjamin Blümchen -> 21][NULL][NULL][NULL][NULL][NULL]",hashTable.toString());
    }


    @Test
    public void testHashTableRemove(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(1,"Hans","Künzler");
        hashTable.add(student);
        hashTable.remove(student);
        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testGraveStone(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(1,"Hans","Künzler");
        hashTable.add(student);
        hashTable.remove(student);
        assertEquals("[NULL][NULL][✝][NULL][NULL][NULL][NULL][NULL][NULL][NULL]",hashTable.toString());
    }

    @Test
    public void testInsertEndOfArray(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(8,"Hans","Künzler");
        hashTable.add(student);
        assertEquals("[NULL][NULL][NULL][NULL][NULL][NULL][NULL][NULL][NULL][Hans Künzler -> 8]",hashTable.toString());
    }

    @Test
    public void testInsertBeyondEndOfArray(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(8,"Hans","Künzler");
        Student student2 = new Student(8,"Freddie","Mercury");
        hashTable.add(student);
        assertFalse(hashTable.add(student2));
    }
}