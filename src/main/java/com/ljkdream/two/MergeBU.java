package com.ljkdream.two;

/**
 * 自底向上的归并排序
 * Created by LJK on 2015-12-02.
 */
public class MergeBU extends AbstractMerge {

    @Override
    protected void initAus(int arrayLength) {
        aux = new Comparable[arrayLength]; //一次性分配空间
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length; //进行 lgN 次两两归并
        this.initAus(N);

        for (int sz = 1; sz < N; sz *= 2) { //sz 子数组大小
            for (int lo = 0; lo < N - sz; lo += 2 * sz) { //lo：子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
}
