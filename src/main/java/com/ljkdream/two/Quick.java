package com.ljkdream.two;

import com.ljkdream.stdlib.StdRandom;

/**
 * 快速排序
 * Created by LJK on 2015-12-02.
 */
public class Quick extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1; //左右扫描指针
        Comparable v = a[lo]; //切分元素

        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break; //从左边开始找到比 v 大的值
            while (less(v, a[--j])) if (j == lo) break; //从右边开始找到比 v 小的值
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); //把v放到正确位置
        return j;//v的正确位置，这个位置是已经排好序的
    }
}
