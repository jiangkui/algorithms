package com.ljkdream.two;

import java.util.Arrays;
import java.util.Collections;

/**
 * 堆排序
 * Created by LJK on 2015-12-04.
 */
public class HeapSort extends AbstractSortExample {
    @Override
    public void sort(Comparable[] a) {
        Comparable[] c = new Comparable[a.length + 1];
        System.arraycopy(a, 0, c, 1, a.length);


        int N = c.length; //0~11
        for (int k = N / 2; k >= 1; k--) { //从最右侧的子堆根节点开始建堆
            sink(c, k, N);
        }

        while (N > 1) {
            exch(c, 1, --N);
            sink(c, 1, N);
        }

        //还原回去
        for (int i = 0; i < a.length; i++) {
            a[i] = c[i + 1];
        }
    }

    private void sink(Comparable[] a, int k, int n) {
        while (leftChile(k) < n) { //获取子孩子值大的那个元素的下标
            int maxIdx = leftChile(k);
            int rightIdx = rightChild(k);

            if (rightIdx < n && less(a[maxIdx], a[rightIdx])) {
                maxIdx = rightIdx;
            }

            if (less(a[k], a[maxIdx])) {
                exch(a, k, maxIdx);
            }
            k = maxIdx;
        }
    }

    public int parent(int k) {
        return k / 2;
    }

    public int leftChile(int p) {
        return 2 * p;
    }

    public int rightChild(int p) {
        return 2 * p + 1;
    }
}
