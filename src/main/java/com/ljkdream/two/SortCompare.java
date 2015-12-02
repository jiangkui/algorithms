package com.ljkdream.two;

import com.ljkdream.stdlib.StdRandom;

/**
 * 排序比较
 * Created by LJK on 2015-11-30.
 */
public class SortCompare {

    /**
     * 针对给定的输入，为本章中的一种排序算法记时
     *
     * @param alg         排序算法
     * @param comparables 待排序数组
     * @return 执行时间
     */
    public static double time(AlgorithmsEnum alg, Comparable[] comparables) {
        Stopwatch stopwatch = new Stopwatch();

        if (alg.equals(AlgorithmsEnum.INSERTION)) {
            new Insertion().sort(comparables);

        } else if (alg.equals(AlgorithmsEnum.SELECTION)) {
            new Selection().sort(comparables);

        } else if (alg.equals(AlgorithmsEnum.SHELL)) {
            new Shell().sort(comparables);
        } else if (alg.equals(AlgorithmsEnum.MERGE)) {
            new Merge().sort(comparables);
        } else if (alg.equals(AlgorithmsEnum.MERGE_BU)) {
            new MergeBU().sort(comparables);
        } else if (alg.equals(AlgorithmsEnum.QUICK)) {
            new Quick().sort(comparables);
        } else {
            System.out.printf("没有匹配到 %s 对象%n", alg);
        }

        return stopwatch.elapsedTime();
    }

    /**
     * 使用算法 alg 将 number 个长度为 length 的数组排序
     *
     * @param alg    算法
     * @param length 长度
     * @param number 个数
     * @return 算法运行时间
     */
    public static double timeRandomInput(AlgorithmsEnum alg, int length, int number) {
        double total = 0.0;
        Double[] a = new Double[length];
        for (int t = 0; t < number; t++) {
            //进行一次测试，生成一个数组并排序
            for (int i = 0; i < length; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    private static void executeAndPrint(AlgorithmsEnum selection, int length, int number) {
        double useTime = timeRandomInput(selection, length, number);
        System.out.printf("%-20.16s 所用时间为：%.3f 秒 %n", selection, useTime);
    }

    public static void main(String[] args) {
        int length = 10000000;
        int number = 1;

        System.out.printf("对 %s 个大小为 %s 位的数组排序结果：%n", number, length);

//        executeAndPrint(AlgorithmsEnum.SELECTION, length, number);
//        executeAndPrint(AlgorithmsEnum.INSERTION, length, number);
//        executeAndPrint(AlgorithmsEnum.SHELL, length, number);
//        executeAndPrint(AlgorithmsEnum.MERGE, length, number);
//        executeAndPrint(AlgorithmsEnum.MERGE_BU, length, number);
        executeAndPrint(AlgorithmsEnum.QUICK, length, number);
    }
}
