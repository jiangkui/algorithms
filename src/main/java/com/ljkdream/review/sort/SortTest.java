package com.ljkdream.review.sort;

import com.ljkdream.two.AbstractSortExample;

/**
 * 排序测试
 * Created by LJK on 2015-11-30.
 */
public class SortTest {
    public static void main(String[] args) {
        String data = "5 7 3 4 9 2 1 8 6";
        data = data.replace(" ", "");

        String[] arrays = new String[data.length()];

        for (int i = 0; i < data.length(); i++) {
            arrays[i] = String.valueOf(data.charAt(i));
        }

        //2016-01-23 复习排序算法
//        AbstractSortExample abstractSortExample = new SelectionSort();
//        AbstractSortExample abstractSortExample = new InsertionSort();
        AbstractSortExample abstractSortExample = new QuickSort();

        abstractSortExample.show(arrays);
        abstractSortExample.sort(arrays);
        abstractSortExample.show(arrays);
    }
}
