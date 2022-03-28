package ch.hslu.ad.Datenstrukturen.Lists.RingBufferQueue;


public class RingBufferQueueGeneric<T> {

    private int readerPosition = 0;
    private int writerPosition = 0;
    private int usedSize = 0;
    private T[] buffer;

    public RingBufferQueueGeneric(int size){
        this.buffer = (T[]) new Object[size];
    }

    public boolean isEmpty(){
        return usedSize == 0;
    }

    public boolean isFull(){
        return usedSize == buffer.length;
    }

    public int getUsedSize(){
        return this.usedSize;
    }

    public boolean enqueue(T character){
        if(isFull()){
            return false;
        }

        buffer[writerPosition] = character;
        usedSize += 1;
        writerPosition += 1;
        if(writerPosition >= buffer.length){ // if we went "one time around"
            writerPosition -= buffer.length;
        }

        return true;

    }

    public T dequeue(){
        if(isEmpty()){
            throw new ArithmeticException("Cannot dequeue. List is empty");
        }

        T item = buffer[readerPosition];
        buffer[readerPosition] = null; // default value
        usedSize -= 1;

        readerPosition += 1;
        if(readerPosition >= buffer.length){
            readerPosition -= buffer.length;
        }

        return item;
    }
}
