package com.spacex.algorithm.base;

import com.spacex.utils.PrintUtils;

import java.util.Arrays;

public class RemoveElementAlgorithm {

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }

        }
        return i;
    }

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static int removeDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int newTail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newTail]) {
                newTail += 1;
                nums[newTail] = nums[i];
            }
        }

        return newTail + 1;
    }

    public static int betterRemoveDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];

        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean neededAdd = true;
            for (int j = 0; j < result.length; j++) {
                if (nums[i] == result[j]) {
                    neededAdd = false;
                    break;
                }
            }

            if (neededAdd) {
                step++;
                result[i] = nums[i];
            }
        }
        nums = result;
        PrintUtils.println("=======");
        for (int item : nums) {
            PrintUtils.println(String.format("%s,%s", step, item));
        }
        return step;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 5, 5, 6};
        int length = removeElement(nums, 5);
        PrintUtils.println(length);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 3, 4, 5, 5, 5, 6};
        length = removeElement2(nums, 5);
        PrintUtils.println(length);
        PrintUtils.println(Arrays.toString(nums));
        int newLength = removeDuplicate(new int[]{1, 3, 4, 6, 5, 5, 6});
        newLength = removeDuplicate(new int[]{6, 6, 6, 6, 5, 5, 6});

    }
}
