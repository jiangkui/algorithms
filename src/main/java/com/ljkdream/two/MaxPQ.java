package com.ljkdream.two;

/**
 * 基于堆的优先队列
 * Created by LJK on 2015-12-03.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; //pq[0] 不使用
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; //从根节点得到最大元素
        exch(1, N--);    //最大元素和最后一个元素交换，sink 将恢复堆的有序性
        pq[N + 1] = null; //防止对象游离
        sink(1); //回复堆的有序性
        return max;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) { j++; } //获取子节点中大的
            if (!less(k, j)) { break; }
            exch(k, j);
            k = j;
        }
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
