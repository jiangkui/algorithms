package com.ljkdream.two;

/**
 * 堆排序
 * Created by LJK on 2015-12-04.
 */
public class HeapSort extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }

//        sink(a, 1, N);

    }

    private void sink(Comparable[] a, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n-1 && less(j, j + 1)) { //获取子孩子值大的那个元素的下标
                j++;
            }

            if (less(k, j)) {
                exch(a, k, j);
            }
            k = j;
        }
    }
}
