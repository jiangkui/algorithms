package com.ljkdream.study;

/**
 * 定容栈的实现
 * Created by ljk on 16-1-22.
 */
public class FixedCapacityStack<T> implements IStack {
    private T[] objects;
    private int N;

    public FixedCapacityStack(int cap) {
        objects = (T[]) new Object[cap];
    }

    public void push(Object item) {
        if (N == objects.length) {
            resize(2 * N);
        }
        objects[N++] = (T) item;
    }

    public T pop() {
        T object = objects[--N];
        objects[N] = null;
        if (N > 0 && N < objects.length / 4) {
            resize(objects.length / 2);
        }
        return object;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int max) {
        T[] items = (T[]) new Object[max];
        for (int i = 0; i < objects.length; i++) {
            items[i] = objects[i];
        }
        objects = items;
    }
}
