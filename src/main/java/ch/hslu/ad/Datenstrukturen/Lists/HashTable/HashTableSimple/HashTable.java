package ch.hslu.ad.Datenstrukturen.Lists.HashTable.HashTableSimple;

import ch.hslu.ad.Datenstrukturen.DemoClasses.Student;

public class HashTable implements HashTableInterface{
    private static final HashItem GRAVESTONE = new HashItem(null);

    private int usedSize;
    private final int size;
    private HashItem[] hashItems;

    public HashTable(final int size){
        this.size = size;
        this.usedSize = 0;
        hashItems = new HashItem[size];

        GRAVESTONE.setGraveStone(true);
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

        while (hasNext(index)){
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

        do{
            if (hashItems[index].getItem().equals(element)){
                hashItems[index] = GRAVESTONE;
                usedSize--;
                return true;
            }

            index++;
        }while (hasNext(index));

        return false;
    }

    @Override
    public boolean contains(Student element) {
        int index = Math.abs(element.hashCode() % this.size);

        while (hasNext(index)){
            if(hashItems[index] != null && hashItems[index].getItem().equals(element)){
                return true;
            }

            index++;
        }

        return false;
    }

    private boolean hasNext(int index){
        return index < size && hashItems[index] != null && hashItems[index] != GRAVESTONE;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<size;i++){
            if(hashItems[i] != null){
                stringBuilder.append(hashItems[i]);
            }else{
                stringBuilder.append("[NULL]");
            }
        }

        return stringBuilder.toString();
    }
}
