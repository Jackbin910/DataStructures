package com.yangbin1.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
    }

    public static int binarySearch(int[] arr,int left,int right,int value) {
        List<String> strings = new ArrayList<>();
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (value > mid) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < mid) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }

}
