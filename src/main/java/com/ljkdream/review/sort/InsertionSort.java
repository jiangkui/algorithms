package com.ljkdream.review.sort;

import com.ljkdream.two.AbstractSortExample;

/**
 * 插入排序
 * Created by ljk on 16-1-23.
 */
public class InsertionSort extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int val = i;
            for (int j = i - 1; j >= 0; j--) {
                if (less(a[val], a[j])) {
                    exch(a, val, j);
                    val = j;
                }
            }
        }
    }
}
