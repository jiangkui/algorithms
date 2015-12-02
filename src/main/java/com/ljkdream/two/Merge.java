package com.ljkdream.two;

/**
 * 归并排序
 * Created by LJK on 2015-12-01.
 */
public class Merge extends AbstractMerge {

    @Override
    protected void initAus(int arrayLength) {
        aux = new Comparable[arrayLength]; //一次性分配空间
    }

    @Override
    public void sort(Comparable[] a) {
        this.initAus(a.length);
        sort(a, 0, a.length - 1);
    }

    /**
     * 递归排序
     * @param a 数组
     * @param lo 起始点
     * @param hi 终止点
     */
    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }



}
