package com.tcooper;

public class Main {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                boolean isEdge = i == 0 || i == arr.length - 1;
                isEdge = isEdge || (j == 0 || j == arr[i].length - 1);

                if (isEdge) continue;

                int count = 0;


                count += arr[i][j];

                count += arr[i + 1][j];
                count += arr[i + 1][j + 1];
                count += arr[i + 1][j - 1];

                count += arr[i - 1][j];
                count += arr[i - 1][j + 1];
                count += arr[i - 1][j - 1];

                if (largest < count) largest = count;
            }
        }


        return largest;
    }

    public static void main(String[] args) {
        // write your code her
        int arr[][] = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int res = hourglassSum(arr);
        System.out.println(res);
    }
}
