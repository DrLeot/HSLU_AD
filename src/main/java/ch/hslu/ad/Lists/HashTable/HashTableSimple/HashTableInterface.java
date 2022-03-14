package ch.hslu.ad.Lists.HashTable.HashTableSimple;

import ch.hslu.ad.DemoClasses.Student;

public interface HashTableInterface {

    void clear();
    boolean add(Student element);
    boolean remove(Student element);
    boolean contains(Student element);
}
