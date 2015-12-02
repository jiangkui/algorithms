package com.ljkdream.two;

import com.ljkdream.stdlib.StdRandom;

/**
 * 快速排序
 * Created by LJK on 2015-12-02.
 */
public class Quick extends AbstractSortExample{
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 切分
     * @param a 数组
     * @param lo lo
     * @param hi hi
     * @return val
     */
    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v)) { //找到左侧比 v 大的元素
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) { //找到右侧比 v 小的元素
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
