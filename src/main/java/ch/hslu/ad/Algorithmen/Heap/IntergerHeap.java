package ch.hslu.ad.Algorithmen.Heap;

public interface IntergerHeap<T> {

    void insert(T value);
    void insertArray(T[] values);
    void reorganizeUp(int index);
    void reorganizeDown(int index);
    T getMax();
}
