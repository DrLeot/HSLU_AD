package ch.hslu.ad.Memory;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation>{

    private final int startAddress;
    private final int size;

    public Allocation(int size, int startAddress) {
        this.size = size;
        this.startAddress = startAddress;
    }

    public int getSize(){
        return this.size;
    };

    public int getStartAddress(){
        return this.startAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startAddress, size);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof final Allocation castedAllocation)){
            return false;
        }
        return (castedAllocation.size == this.size) && (castedAllocation.startAddress == this.startAddress);
    }

    @Override
    public int compareTo(Allocation o) {
        if(this.getStartAddress() < o.getStartAddress()) {
            return -1;
        } else if(this.getStartAddress() > o.getStartAddress()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Allocation[Address:"+startAddress+"; Size:"+size+"]";
    }


}
