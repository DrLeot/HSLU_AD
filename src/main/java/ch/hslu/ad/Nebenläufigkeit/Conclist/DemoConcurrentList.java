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
package ch.hslu.ad.Nebenläufigkeit.Conclist;

import java.util.*;
import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstration einer synchrnisierten List mit n Producer und m Consumer.
 */
public final class DemoConcurrentList {

    private static final int MAX = 10000;
    private static final Logger LOG = LogManager.getLogger(DemoConcurrentList.class);

    /**
     * Privater Konstruktor.
     */
    private DemoConcurrentList(List<Integer> list){
        final ExecutorService executor = Executors.newCachedThreadPool();

        try{
            final List<Future<Long>> futures = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                futures.add(executor.submit(new Producer(list, MAX)));
            }
            Iterator<Future<Long>> iterator = futures.iterator();
            long totProd = 0;
            while (iterator.hasNext()) {
                long sum = iterator.next().get();
                totProd += sum;
                LOG.info("prod sum = " + sum);
            }
            LOG.info("prod tot = " + totProd);
            long totCons = executor.submit(new Consumer(list)).get();
            LOG.info("cons tot = " + totCons);
        }catch (Exception exception){
            LOG.error(exception);
        }finally {
            executor.shutdown();
        }
    }
    private DemoConcurrentList(BlockingQueue<Integer> integerBlockingQueue){
        final ExecutorService executor = Executors.newCachedThreadPool();
        try {
            final List<Future<Long>> futures = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                futures.add(executor.submit(new ProducerQueue(integerBlockingQueue, MAX)));
            }
            Iterator<Future<Long>> iterator = futures.iterator();
            long totProd = 0;
            while (iterator.hasNext()) {
                long sum = iterator.next().get();
                totProd += sum;
                LOG.info("prod sum = " + sum);
            }
            LOG.info("prod tot = " + totProd);
            long totCons = executor.submit(new ConsumerQueue(integerBlockingQueue)).get();
            LOG.info("cons tot = " + totCons);
        }catch (Exception exception){
            LOG.error(exception);
        }finally {
            executor.shutdown();
        }
    }

    /**
     * Main-Demo.
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException bei Excecution-Fehler.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {
        long startTime;

        startTime = System.currentTimeMillis();
        new DemoConcurrentList(new LinkedList<>());
        LOG.info(System.currentTimeMillis()-startTime+" ms");
        LOG.info("******************");

        startTime = System.currentTimeMillis();
        new DemoConcurrentList(Collections.synchronizedList(new LinkedList<>()));
        LOG.info(System.currentTimeMillis()-startTime+" ms");
        LOG.info("******************");

        startTime = System.currentTimeMillis();
        new DemoConcurrentList(new LinkedBlockingDeque<>());
        LOG.info(System.currentTimeMillis()-startTime+" ms");
        LOG.info("******************");
    }

}
