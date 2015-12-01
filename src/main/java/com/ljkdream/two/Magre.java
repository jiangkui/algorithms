package com.ljkdream.two;

/**
 * 归并排序
 * Created by LJK on 2015-12-01.
 */
public class Magre extends AbstractSortExample {

    private Comparable[] aux; //归并所需要的辅助数组

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length]; //一次性分配空间
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
        marge(a, lo, mid, hi);
    }

    /**
     * 归并结果
     * @param a 数组
     * @param lo 起始点
     * @param mid 中间点
     * @param hi 终止点
     */
    private void marge(Comparable[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) { //复制一份
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;

        //合并
        for (int k = lo; k <= hi; k++) {
            //取左右两边较小的值，如果左边用尽了则使用右边的元素。右边用尽，则反之
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
