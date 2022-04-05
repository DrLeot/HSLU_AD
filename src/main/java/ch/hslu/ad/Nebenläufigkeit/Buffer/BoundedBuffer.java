/*
 * Copyright 2022 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.Nebenläufigkeit.Buffer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;

    private final int maxSize;
    private int usedSize;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);

        this.maxSize = n;
        this.usedSize = 0;
    }

    @Override
    public void put(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
            usedSize++;
        }
        takeSema.release();
    }

    @Override
    public T get() throws InterruptedException {
        takeSema.acquire();
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
            usedSize--;
        }
        putSema.release();
        return elem;
    }

    @Override
    public synchronized boolean put(T elem, long millis) throws InterruptedException {
        while (full()){
            this.wait(millis);
            if (full()){
                return false;
            }
        }


        putSema.acquire();
        queue.addFirst(elem);
        usedSize++;
        takeSema.release();

        return true;
    }

    @Override
    public synchronized T get(long millis) throws InterruptedException {
        while (empty()) {
            this.wait(millis);
        }

        takeSema.acquire();
        T elem;

        elem = queue.removeLast();
        usedSize--;
        putSema.release();
        return elem;
    }

    @Override
    public T first() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T last() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean empty() {
        return this.usedSize <= 0;
    }

    @Override
    public boolean full() {
        return this.usedSize >= this.maxSize;
    }

    @Override
    public int size() {
        return this.maxSize;
    }
}
