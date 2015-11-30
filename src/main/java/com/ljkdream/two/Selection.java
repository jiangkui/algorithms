package com.ljkdream.two;

/**
 * 选择排序
 * Created by LJK on 2015-11-30.
 */
public class Selection extends AbstractSortExample {

    @Override
    public void sort(Comparable[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
