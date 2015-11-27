package com.ljkdream.one;

import com.ljkdream.stdlib.StdOut;

/**
 * Test
 * Created by LJK on 2015/11/27.
 */
public class Test {
    public static void main(String[] args) {
//        double t = 9.0;
//        while (Math.abs(t - 9.0 / t) > .001) {
//            t = (9.0 / t + t) / 2.0;
//        }
//        StdOut.printf("%.5f\n", t);

        exR2(3);
    }

    /**
     * 以下代码会递归调用，知道 StackOverFlowError
     * @param n n
     * @return String
     */
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }
}
