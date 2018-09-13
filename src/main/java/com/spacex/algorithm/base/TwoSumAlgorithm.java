package com.spacex.algorithm.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumAlgorithm {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] numbers = new int[]{1, 3, 4, 5, 6, 7, 10};
        int target = 11;
        int[] result = twoSum(numbers, target);
        System.out.println(String.format("[twoSum] %s,%s target:%s", numbers[result[0]], numbers[result[1]], target));
        result = twoSumWithBruteForce(numbers, target);
        System.out.println(String.format("[twoSumWithBruteForce] %s,%s target:%s", numbers[result[0]], numbers[result[1]], target));
        result = twoSumWithOnePass(numbers, target);
        System.out.println(String.format("[twoSumWithOnePass] %s,%s target:%s", numbers[result[0]], numbers[result[1]], target));

    }

    /**
     * two pass
     * <p>
     * time complexity: O(n)
     * <p>
     * space complexity: O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                int indexOfComplement = map.get(complement);
                return new int[]{i, indexOfComplement};
            }
        }

        throw new IllegalArgumentException(String.format("no two sum solution,numbers:%s,target:%s", Arrays.toString(numbers), target));
    }

    /**
     * only one pass
     * time complexity:O(n)
     * space complexity:O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumWithOnePass(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }

            map.put(numbers[i], i);

        }

        throw new IllegalArgumentException(String.format("no tow sum solution,numbers:%s,target:%S", Arrays.toString(numbers), target));
    }

    /**
     * brute force with two pass
     * <p>
     * time complexity: O(n^2)
     * space complexity: o(1)
     *
     * @param numbers
     * @param target
     */
    public static int[] twoSumWithBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int complement = target - numbers[i];
                if (numbers[j] == complement) {
                    return new int[]{i, j};
                }

            }
        }

        throw new IllegalArgumentException(String.format("no two sum solution,numbers:%s,target:%s", Arrays.toString(numbers), target));
    }
}
