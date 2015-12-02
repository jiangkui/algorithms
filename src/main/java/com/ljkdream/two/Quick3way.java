package com.ljkdream.two;

import com.ljkdream.stdlib.StdRandom;

/**
 * 三项切分的快速排序
 * Created by LJK on 2015-12-02.
 */
public class Quick3way extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i ++;
        } //现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi] 成立
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
