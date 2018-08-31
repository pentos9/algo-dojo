package com.spacex.algorithm.base;

import com.spacex.utils.PrintUtils;

public class LongCommonPrefixAlgorithm {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        PrintUtils.println(longestCommonPrefix(new String[]{"hello", "hell", "hen"}));
        PrintUtils.println(longestCommonPrefix(new String[]{"hello", "zoo", "mac"}));
        PrintUtils.println(longestCommonPrefix2(new String[]{"hello", "hell", "hen"}));
    }

    public static String longestCommonPrefix(String[] strings) {
        final String EMPTY = "";

        if (strings.length == 0) {
            return EMPTY;
        }

        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return EMPTY;
                }
            }
        }

        return prefix;

    }

    public static String longestCommonPrefix2(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        for (int i = 0; i < strings[0].length(); i++) {
            char c = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++) {
                if (i == strings[j].length() || strings[j].charAt(i) != c) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[0];
    }
}
