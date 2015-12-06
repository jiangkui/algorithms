package com.ljkdream.three;

/**
 * 二分法查找
 * Created by LJK on 2015-12-06.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;//数组长度

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        N = capacity;
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value;
        N ++ ;
    }

    private int rank(Key key) {
        int lo = 0, hi = N -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid -1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    private boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}
