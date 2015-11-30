package com.ljkdream.two;

/**
 * 插入排序
 * Created by LJK on 2015-11-30.
 */
public class Insertion extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        int size = a.length;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
