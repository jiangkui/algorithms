package com.ljkdream.two;

/**
 * 希尔排序
 * Created by LJK on 2015-12-01.
 */
public class Shell extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            //将数组变为 h 有序，数组中任意间隔为 h 的元素都是有序的
            for (int i = h; i < N; i++) {

                //将 a[i] 与 a[i-h] a[i-2*h] a[i-3*h]... 比较
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
