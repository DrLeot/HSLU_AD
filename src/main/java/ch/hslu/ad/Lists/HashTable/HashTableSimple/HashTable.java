package ch.hslu.ad.Lists.HashTable.HashTableSimple;

import ch.hslu.ad.DemoClasses.Student;

public class HashTable implements HashTableInterface{

    private int usedSize;
    private final int size;
    private HashItem[] hashItems;

    public HashTable(final int size){
        this.size = size;
        this.usedSize = 0;
        hashItems = new HashItem[size];
    }

    public boolean isEmpty(){
        return usedSize <= 0;
    }

    public boolean isFull(){
        return usedSize >= size;
    }

    @Override
    public void clear() {
        hashItems = new HashItem[size];
    }

    @Override
    public boolean add(Student element) {
        int index = Math.abs(element.hashCode() % this.size);

        while (hashItems[index] != null){
            if (index > this.size) { // end reached
                return false;
            }
            if(hashItems[index].getItem().equals(element)){ // duplicates not allowed
                return false;
            }

            index++;
        }

        hashItems[index] = new HashItem(element);
        usedSize++;
        return true;
    }

    @Override
    public boolean remove(Student element) {
        int index = Math.abs(element.hashCode() % this.size);

        hashItems[index] = null;
        usedSize--;
        return true;
    }

    @Override
    public boolean contains(Student element) {
        int index = Math.abs(element.hashCode() % this.size);

        do {
            if(hashItems[index] != null && hashItems[index].getItem().equals(element)){
                return true;
            }

            index++;
        }while (index < size && hashItems[index] != null);

        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<size;i++){
            if(hashItems[i] != null){
                stringBuilder.append("["+ hashItems[i].getItem().getID() +"]");
            }else{
                stringBuilder.append("[NULL]");
            }
        }

        return stringBuilder.toString();
    }
}
