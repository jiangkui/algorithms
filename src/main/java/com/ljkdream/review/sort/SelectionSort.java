package com.ljkdream.review.sort;

import com.ljkdream.two.AbstractSortExample;

/**
 * 选择排序
 * Created by ljk on 16-1-23.
 */
public class SelectionSort extends AbstractSortExample {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (!less(a[min], a[j])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }
}
