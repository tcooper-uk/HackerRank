package com.tcooper;

public class Main {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int swapCounter = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            boolean positionValid = i == (arr[i] -1);

            while (!positionValid){
                swapPlaces(i, (arr[i] - 1), arr);
                swapCounter++;

                positionValid = i == (arr[i] - 1);
            }
        }

        return swapCounter;
    }


    static void swapPlaces(int index1, int index2, int[] arr) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }


    public static void main(String[] args) {
	    // write your code here
        int[] a = new int[]{7, 1, 3, 2, 4, 5, 6};

        int swaps = minimumSwaps(a);

        System.out.println("It took: " + swaps); // 5

        // write your code here
        int[] b = new int[]{4, 3, 1, 2};
        int swapsb = minimumSwaps(b);
        System.out.println("It took: " + swapsb); // 3


        // write your code here
        int[] c = new int[]{2, 3, 4, 1, 5};
        int swapsc = minimumSwaps(c);
        System.out.println("It took: " + swapsc); // 3

        // write your code here
        int[] d = new int[]{1, 3, 5, 2, 4, 6, 7};
        int swapsd = minimumSwaps(d);
        System.out.println("It took: " + swapsd); // 3
    }
}
