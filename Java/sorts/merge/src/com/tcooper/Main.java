package com.tcooper;

import java.util.Arrays;

public class Main {

    /**
     * Performs a merge sort on the given array
     * @param arr
     * @return a sorted array
     */
    private static int[] mergeSort(int[] arr) {

        // two items, sort then and return
        if(arr.length == 2) return sort(arr);

        // more items to break up
        if(arr.length > 2) {

            // split array in half
            int[] left = new int[arr.length % 2 == 0 ? arr.length / 2 : (arr.length + 1) / 2];
            int[] right = new int[arr.length - left.length];

            System.arraycopy(arr, 0, left, 0, left.length);
            System.arraycopy(arr, left.length, right, 0, right.length);

            // repeat
            left = mergeSort(left);
            right = mergeSort(right);

            // merges the two sorted portions
            return mergeArrays(left, right);
        }

        // no or one elements, already sorted.
        return arr;
    }

    /**
     * Merges the two arrays in sorted order
     * @param left
     * @param right
     * @return sorted array
     */
    private static int[] mergeArrays(int[] left, int[] right) {

        int[] mergedArr = new int[left.length + right.length];

        int mergePos = 0;
        int leftPoint = 0;
        int rightPoint = 0;

        int leftLen = left.length;
        int rightLen = right.length;

        boolean hasLeftValues = leftPoint < leftLen;
        boolean hasRightValues = rightPoint < rightLen;

        while (hasLeftValues || hasRightValues) {

            if(hasLeftValues && hasRightValues) {

                mergedArr[mergePos++] = left[leftPoint] < right[rightPoint] ?
                        left[leftPoint++] :
                        right[rightPoint++];

            } else {
                mergedArr[mergePos++] = hasLeftValues ?
                        left[leftPoint++] :
                        right[rightPoint++];
            }

            hasLeftValues = leftPoint < leftLen;
            hasRightValues = rightPoint < rightLen;
        }

        return mergedArr;
    }

    /**
     * Sort an array of two values
     * @param arr
     * @return sorted array
     */
    private static int[] sort(int[] arr){
        if(arr[0] > arr[1]) {
            int temp = arr[1];
            arr[1] = arr[0];
            arr[0] = temp;
        }
        return arr;
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        
        // 0, 2, 5, 7, 8, 15, 20
        int[] test = new int[] {5,7,2,20,8,0,15};

        var sorted = mergeSort(test);
        System.out.print(Arrays.toString(sorted));
    }
}
