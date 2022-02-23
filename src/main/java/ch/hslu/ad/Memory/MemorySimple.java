package ch.hslu.ad.Memory;

import java.util.HashSet;
import java.util.Set;

public class MemorySimple implements Memory {

    private final int size;
    private final Set<Allocation> allocations = new HashSet<>();

    public MemorySimple(int size) {
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    private int getFreeAddress() {
        Allocation lastAllocation = null;
        for(Allocation allocation : allocations) {
            if(lastAllocation == null || allocation.getStartAddress() >= lastAllocation.getStartAddress()) {
                lastAllocation = allocation;
            }
        }
        if(lastAllocation == null) {
            return 0;
        }
        return lastAllocation.getStartAddress() + lastAllocation.getSize();
    }

    public int getUsedSize(){
        int sum = 0;
        for (Allocation allocation: allocations) {
            sum += allocation.getSize();
        }
        return sum;
    }

    @Override
    public Allocation malloc(int size) {
        Allocation allocation = new Allocation(size, getFreeAddress());
        allocations.add(allocation);
        return allocation;
    }

    @Override
    public void free(Allocation block) {
        allocations.remove(block);
    }

    @Override
    public void clear() {
        allocations.clear();
    }

    @Override
    public String toString() {
        return "MemorySimple[Belegt:"+getUsedSize()+"; Frei:"+(size-getUsedSize())+"]";
    }
}
