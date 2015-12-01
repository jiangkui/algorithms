package com.ljkdream.two;

/**
 * 算法名称枚举
 * Created by LJK on 2015-11-30.
 */
public enum AlgorithmsEnum {
    SELECTION("选择排序"), INSERTION("插入排序"),
    SHELL("希尔排序"), MARGE("归并排序");

    private String chineseName;

    AlgorithmsEnum(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    public String toString() {
        return chineseName;
    }
}
