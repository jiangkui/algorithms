package com.ljkdream.review.sort;

import com.ljkdream.two.AbstractSortExample;

/**
 * 快速排序
 * Created by jiangkui on 16-1-24.
 */
public class QuickSort extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++left], v)) { //从左边开始找到比 v 大的值
                if (left == hi) break;
            }

            while (less(v, a[--right])) { //从右边开始找到比 v 小的值
                if (right == lo) break;
            }

            if (left >= right) break;

            exch(a, left, right); //交换两个找到的值（一个比v大的，一个比v小的）
        }
        exch(a, lo, right);//把v放到正确位置，交换v与最靠右边的一个比v小的值

        return right;//v的正确位置，这个位置是已经排好序的
    }
}
