package com.yangbin1.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
    }

    public static void quickSort(int[] arr,int left,int right) {
        int l = left; // 左下标
        int r = right;
        //中轴值
        int middle = arr[(left + right) / 2];
        int temp = 0;
        //循环的目的是让小于中轴值放到左边，大的放到右边
        while (l < r) {
            while (arr[l] < middle) {
                l += 1;
            }
            while (arr[r] > middle) {
                r -= 1;
            }
            //说明左右两边的值已经按照左边小于中值，右边大于中值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完发现arr[l] == middle ,r前移
            if (arr[l] == middle) {
                r -= 1;
            }
            //如果交换完发现arr[r] == middle ,l后移
            if (arr[r] == middle) {
                l += 1;
            }
        }

        //如果l==r,必须l++，r--，否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
