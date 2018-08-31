package com.spacex.algorithm.base;

import java.util.ArrayList;
import java.util.Collection;

public class PalindromeNumberAlgorithm {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println(palindrome(123));
        System.out.println(palindrome(111));
        System.out.println(palindrome(123454321));
        System.out.println(palindrome(0));
        System.out.println("[isPalindrome]" + isPalindrome(0));
        System.out.println("[isPalindrome]" + isPalindrome(123456));
        System.out.println("[isPalindrome]" + isPalindrome(1111));
        System.out.println("[isPalindrome]" + isPalindrome(121));
    }

    public static boolean isPalindrome(int number) {
        String numberText = String.valueOf(number);
        int start = 0;
        int end = numberText.length() - 1;

        while (start < end) {
            if (numberText.charAt(start++) != numberText.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean palindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x / 10 != 0)) {
            return false;
        }
        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reversedNumber || x == (reversedNumber / 10);
    }
}
