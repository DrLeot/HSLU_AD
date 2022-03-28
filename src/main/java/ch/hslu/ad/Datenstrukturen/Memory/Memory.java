package ch.hslu.ad.Datenstrukturen.Memory;

public interface Memory {
    Allocation malloc(int size);
    void free(Allocation block);
    void clear();
}
