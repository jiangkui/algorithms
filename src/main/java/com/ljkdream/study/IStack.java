package com.ljkdream.study;

/**
 * 栈接口
 * Created by ljk on 16-1-22.
 */
public interface IStack<T> {

    void push(T item);

    /**
     * 删除最近添加的对象
     * @return 最近添加的对象
     */
    T pop();

    boolean isEmpty();

    int size();

    void resize(int max);
}
