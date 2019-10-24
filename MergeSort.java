//package com.jx;

import java.util.Arrays;
// Time: 平均：O(n log n)       最坏：O(n log n)       最好：O(n log n)
// Space: O (n)   以为每一次递归都用了一个临时temp【】  其实还有个递归栈为 logN
public class MergeSort {

    public static void main(String[] args) {
        int[] test1 = new int[]{2,4,0,8,7,6,9,5,3,4};
        int[] test2 = new int[]{9,-1,0,5,-3,2,7,4,-4};
        sort(test2);
        System.out.println(Arrays.toString(test2));
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 每次都需要额外的temp来保存merge以后排好序的这两段   最后再重新写回原arr
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int index = 0; index < temp.length; index++) {
            arr[left++] = temp[index];
        }
    }
}
