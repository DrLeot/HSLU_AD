package ch.hslu.ad.Lists.HashTable.HashTableSimple;

import ch.hslu.ad.DemoClasses.Student;

public final class HashItem {
    private final Student item;

    public HashItem(Student item){
        this.item = item;
    }

    public Student getItem() {
        return item;
    }
}
