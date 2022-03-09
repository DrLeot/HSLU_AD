package ch.hslu.ad.Lists.RingBufferQueue;


public class RingBufferQueue {

    private int readerPosition = 0;
    private int writerPosition = 0;
    private int usedSize = 0;
    private char[] buffer;

    public RingBufferQueue(int size){
        this.buffer = new char[size];
    }

    public boolean isEmpty(){
        return usedSize <= 0;
    }

    public boolean isFull(){
        return usedSize == buffer.length;
    }

    public int getUsedSize(){
        return this.usedSize;
    }

    public boolean enqueue(char character){
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

    public char dequeue(){
        if(isEmpty()){
            throw new ArithmeticException("Cannot dequeue. List is empty");
        }

        char item = buffer[readerPosition];
        buffer[readerPosition] = Character.MIN_VALUE; // default value of char in java
        usedSize -= 1;

        readerPosition += 1;
        if(readerPosition >= buffer.length){
            readerPosition -= buffer.length;
        }

        return item;
    }
}
