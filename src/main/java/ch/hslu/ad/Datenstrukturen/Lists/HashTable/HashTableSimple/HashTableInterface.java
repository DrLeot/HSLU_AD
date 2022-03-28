package ch.hslu.ad.Datenstrukturen.Lists.HashTable.HashTableSimple;

import ch.hslu.ad.Datenstrukturen.DemoClasses.Student;

public interface HashTableInterface {

    void clear();
    boolean add(Student element);
    boolean remove(Student element);
    boolean contains(Student element);
}
