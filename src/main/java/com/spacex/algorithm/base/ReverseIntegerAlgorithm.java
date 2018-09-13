package com.spacex.algorithm.base;

public class ReverseIntegerAlgorithm {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        //reverse(-9646324351);
        reverse2(1534236469);
        reverse(-2147483648);
        reverse(-1534236469);
        reverse(7896);
        reverse(0);
    }

    /**
     * not perfect because there are some overflow cases exist:
     * time complexity:
     * space complexity:
     *
     * @param number
     * @return
     */
    public static int reverse(int number) {
        final int ZERO = 0;
        if (number >= Integer.MAX_VALUE || number <= Integer.MIN_VALUE) {
            System.out.println("[Warning]number is overflow:" + number);
            number = 0;
        }

        int absNumber = Math.abs(number);

        String text = Integer.toString(absNumber);
        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        if (number < 0) {
            stringBuilder.append("-");
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }

        long check = Long.parseLong(stringBuilder.toString());

        if (check > Integer.MAX_VALUE || check < Integer.MIN_VALUE) {
            return ZERO;
        }

        int reverseNumber = Integer.parseInt(stringBuilder.toString());
        System.out.println(reverseNumber);

        return reverseNumber;

    }

    /**
     * Time Complexity: O(log(x))
     * O(log(x))
     * <p>
     * space Complexity:O(1)
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int rev = 0;
        int ZERO = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Integer.MAX=2147483647,Integer.MIN= -2147483648
            if (rev > (Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                System.out.println(ZERO);
                return ZERO;
            }

            if (rev < (Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                System.out.println(ZERO);
                return ZERO;
            }

            rev = rev * 10 + pop;
        }

        System.out.println(rev);
        return rev;
    }
}