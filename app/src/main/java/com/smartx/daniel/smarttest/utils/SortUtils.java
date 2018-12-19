package com.smartx.daniel.smarttest.utils;

import java.util.Arrays;

/**
 * created by daniel on 2018/12/6
 * <p>
 * 数组排序 参考Arrays.sort()
 */
public class SortUtils {

    public int[] sort(int[] array) {

        Arrays.sort(array);

        return array;
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {

        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;

        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }


    /**
     * 快速排序
     */

    public static int[] quickSort(int[] arr, int left, int right) {

        int len = arr.length;
        left = (left < 0) ? 0 : left;
        right = (right >= len) ? len - 1 : right;
        int partitionIndex;
        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {

        int index = left + 1;

        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
                Logger.d("arr = "+Arrays.toString(arr));
            }
        }
        swap(arr, left, index - 1);
        Logger.d("index = "+index);
        return index - 1;

    }

    private static void swap(int[] arr, int i, int j) {
        if(i==j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] memerySort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
        return arr;

    }

    private static void mSort(int[] arr, int left, int right) {
        int middle = (left + right) / 2;
        if(left<right) {
            mSort(arr, left, middle);
            mSort(arr, middle + 1, right);
            memery(arr, left, middle, right);
        }
    }

    private static void memery(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int   i    = left;
        int   j    = middle + 1;
        int   k    = 0;
        while (i <= middle && j <= right) {
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while (i<=middle){
            temp[k++] = arr[i++];
        }
        while (j<=right){
            temp[k++] = arr[j++];
        }

        for (int l = 0; l <k ; l++) {
            arr[left+l] = temp[l];
        }
    }


}
