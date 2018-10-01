package com.spacex.algorithm.classic;

import com.spacex.utils.PrintUtils;

import java.util.Arrays;
import java.util.List;

public class TopKSelectorTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> src = Arrays.asList(1, 0, 5, 7, 8, 89, -1, 10);
        List<Integer> result = TopKSelector.selectThenMap(src, 5, Integer::valueOf);
        PrintUtils.println(result);
    }
}
