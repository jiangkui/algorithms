package com.ljkdream.two;

/**
 * 排序测试
 * Created by LJK on 2015-11-30.
 */
public class SortTest {
    public static void main(String[] args) {
        String data = "S O R T E X A M P L E";
        data = data.replace(" ", "");

        String[] arrays = new String[data.length()];

        for (int i = 0; i < data.length(); i++) {
            arrays[i] = String.valueOf(data.charAt(i));
        }


//        AbstractSortExample abstractSortExample = new Selection();
//        AbstractSortExample abstractSortExample = new Insertion();
//        AbstractSortExample abstractSortExample = new Shell();
//        AbstractSortExample abstractSortExample = new Merge();
//        AbstractSortExample abstractSortExample = new MergeBU();
//        AbstractSortExample abstractSortExample = new Quick();
//        AbstractSortExample abstractSortExample = new Quick3way();
        AbstractSortExample abstractSortExample = new HeapSort();

        abstractSortExample.show(arrays);
        abstractSortExample.sort(arrays);
        abstractSortExample.show(arrays);
    }
}
