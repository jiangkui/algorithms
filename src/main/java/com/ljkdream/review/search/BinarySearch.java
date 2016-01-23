package com.ljkdream.review.search;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找
 * Created by ljk on 16-1-23.
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        //首先数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            //被查找的键要么不存在，要么必然在 a[lo..hi]之中
            int mid = lo + (hi - lo) / 2; //lo 与 hi 的中间值
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int arr[] = new int[50];
        for (int i = 0; i < arr.length; i++) {
            int i1 = random.nextInt(10);
            arr[i] = i1;
        }

        Arrays.sort(arr);

        for (int i = 0; i < 5; i++) {
            int i1 = random.nextInt(10);
            int index = BinarySearch.rank(i1, arr);
            System.out.println(i1 + " 在数组中的位置：" + index);
        }
    }
}
