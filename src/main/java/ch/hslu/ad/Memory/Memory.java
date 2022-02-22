package ch.hslu.ad.Memory;

public interface Memory {
    Allocation malloc(int size);
    void free(Allocation block);
}
