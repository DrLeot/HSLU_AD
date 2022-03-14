package ch.hslu.ad.Lists.HashTable;

import ch.hslu.ad.DemoClasses.Student;
import ch.hslu.ad.Lists.HashTable.HashTableSimple.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


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
    public void testHashTableSondierenOnce(){
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Student(1,"Hans","Künzler"));
        hashTable.add(new Student(11,"Karla","Kolumna"));
        assertEquals("[NULL][NULL][1][11][NULL][NULL][NULL][NULL][NULL][NULL]",hashTable.toString());
    }
    @Test
    public void testHashTableSondierenTwice(){
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Student(1,"Hans","Künzler"));
        hashTable.add(new Student(11,"Karla","Kolumna"));
        hashTable.add(new Student(21,"Benjamin","Blümchen"));
        assertEquals("[NULL][NULL][1][11][21][NULL][NULL][NULL][NULL][NULL]",hashTable.toString());
    }

    @Test
    public void testHashTableRemove(){
        HashTable hashTable = new HashTable(10);
        Student student = new Student(1,"Hans","Künzler");
        hashTable.add(student);
        hashTable.remove(student);
        assertTrue(hashTable.isEmpty());
    }
}