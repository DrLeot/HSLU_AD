package ch.hslu.ad.Algorithmen.Heap;


import java.util.Arrays;

public final class FixedSizeHeap<T extends Comparable<? super T>> implements IntergerHeap<T>{

    private final int size;
    private int tailIndex;
    private final T[] heap;

    public FixedSizeHeap(int size){
        this.size = size;
        this.heap = (T[]) new Comparable[size];
        this.tailIndex = 0;
    }

    @Override
    public void insert(T value) {
        heap[tailIndex] = value;
        reorganizeUp(tailIndex);

        if(tailIndex < heap.length - 1){
            tailIndex++;
        }
    }

    @Override
    public void insertArray(T[] values){
        for (T value : values) {
            insert(value);
        }
    }

    @Override
    public void reorganizeUp(int index) {
        if (index == 0){
            return;
        }

        int parentIndex = (index - 1) / 2;
        compareAndSwap(index, parentIndex);
        reorganizeUp(parentIndex);
    }

    @Override
    public void reorganizeDown(int index) {
        int leftChildIndex = (index * 2) + 1;
        int rightChildIndex = (index + 1) * 2;
        int swapIndex;

        if (leftChildIndex >= heap.length && rightChildIndex >= heap.length){
            return;
        }
        if (leftChildIndex < heap.length) {
            if (rightChildIndex < heap.length) {
                if(heap[leftChildIndex].compareTo(heap[rightChildIndex]) >= 0){ // A >= B
                    swapIndex = leftChildIndex;
                }else{
                    swapIndex = rightChildIndex;
                }
            }else{
                swapIndex = leftChildIndex;
            }
            compareAndSwap(swapIndex, index);
            reorganizeDown(swapIndex);
        } else {
            compareAndSwap(rightChildIndex, index);
            reorganizeDown(rightChildIndex);
        }
    }

    @Override
    public T getMax() {
        T max = this.heap[0];
        this.heap[0] = this.heap[tailIndex];
        this.heap[tailIndex] = null;
        reorganizeDown(tailIndex);
        tailIndex--;

        return max;
    }

    private void compareAndSwap(int indexA, int indexB) {
        if (heap[indexA].compareTo(heap[indexB]) > 0){ // A > B
            T old = heap[indexB];
            heap[indexB] = heap[indexA];
            heap[indexA] = old;
        }
   }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
