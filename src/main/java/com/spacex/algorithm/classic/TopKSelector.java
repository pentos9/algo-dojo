package com.spacex.algorithm.classic;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Function;

public class TopKSelector {

    public static <T extends Comparable<? super T>, R> List<R> selectThenMap(Iterable<? extends T> src, int k, Function<? super T, ? extends R> function) {
        Objects.requireNonNull(src, "src null!");
        if (k <= 0) {
            throw new IllegalArgumentException("'k' must be positive number!");
        }

        PriorityQueue<T> heap = new PriorityQueue<>(k);
        int elementCount = 0;
        for (T t : src) {
            Objects.requireNonNull(t, "t null!");
            elementCount++;
            if (elementCount < k) {
                heap.add(t);
            } else {
                T top = heap.peek();
                assert top != null;
                if (top.compareTo(t) < 0) {
                    heap.poll();
                    heap.add(t);
                }
            }
        }
        return asList(heap, function);
    }


    public static <T extends Comparable<? super T>> List<T> select(Iterable<T> src, int k) {
        return selectThenMap(src, k, Function.identity());
    }


    private static <T, R> List<R> asList(PriorityQueue<T> priorityQueue, Function<? super T, ? extends R> function) {
        R[] a = (R[]) new Object[priorityQueue.size()];
        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = function.apply(priorityQueue.poll());
        }
        return Arrays.asList(a);
    }
}
