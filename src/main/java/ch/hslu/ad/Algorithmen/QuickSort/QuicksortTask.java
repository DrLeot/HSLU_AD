/*
 * Copyright 2022 Hochschule Luzern Informatik.
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
package ch.hslu.ad.Algorithmen.QuickSort;

import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 1;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        // Copy and Adaption from ch.hslu.ad.Algorithmen.Sort.java
        int up = this.min;
        int down = this.max - 1;
        int t = array[this.max];
        boolean allChecked = false;
        do {
            while (array[up] < t) {
                up++;
            }
            while ((array[down] > t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(array, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(array, up, this.max);

        QuicksortTask leftSide = null;
        if (this.min < (up - 1)){
            leftSide = new QuicksortTask(array, this.min, (up - 1));
            leftSide.fork();
        }
        QuicksortTask rightSide = null;
        if ((up + 1) < this.max){
            rightSide = new QuicksortTask(array, (up + 1), this.max);
            rightSide.fork();
        }
        if(leftSide != null){
            leftSide.join();
        }
        if(rightSide != null){
            rightSide.join();
        }
    }

    private static void exchange(final int[] a,
                                 final int firstIndex,
                                 final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }
}
