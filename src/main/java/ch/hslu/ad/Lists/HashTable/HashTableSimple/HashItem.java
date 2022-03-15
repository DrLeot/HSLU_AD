package ch.hslu.ad.Lists.HashTable.HashTableSimple;

import ch.hslu.ad.DemoClasses.Student;

public final class HashItem {
    private final Student item;
    private boolean isGraveStone;

    public HashItem(Student item){
        this.item = item;
        isGraveStone = false;
    }

    public Student getItem() {
        return item;
    }

    public boolean isGraveStone() {
        return isGraveStone;
    }

    public void setGraveStone(boolean graveStone) {
        isGraveStone = graveStone;
    }

    @Override
    public String toString() {
        if(isGraveStone){
            return "[✝]";
        }else{
            return "["+item.toString()+"]";
        }
    }
}
