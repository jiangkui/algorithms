package com.ljkdream.two;

/**
 * 排序比较
 * Created by LJK on 2015-11-30.
 */
public class SortCompare {

    public static double time(String alg, Comparable[] comparables) {
        Stopwatch stopwatch = new Stopwatch();

        if (alg.equals("Insertion")) {
            new Insertion().sort(comparables);

        } else if (alg.equals("Selection")) {
            new Selection().sort(comparables);

        }

        return stopwatch.elapsedTime();
    }
}
