package com.ljkdream.two;

/**
 * 抽象的归并排序类
 * Created by LJK on 2015-12-02.
 */
public abstract class AbstractMerge extends AbstractSortExample {

    protected Comparable[] aux; //子类负责初始化

    /**
     * 子类实现，初始化辅助数组
     * @param arrayLength 数组长度
     */
    protected abstract void initAus(int arrayLength);

    /**
     * 归并结果
     * @param a 数组
     * @param lo 起始点
     * @param mid 中间点
     * @param hi 终止点
     */
    protected void merge(Comparable[] a, int lo, int mid, int hi) {

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
