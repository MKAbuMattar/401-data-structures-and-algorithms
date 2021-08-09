package sort;

import java.util.Arrays;

public class Sort<T extends Comparable<T>> {
    /**
     * Using insertion sort, sorts array items from least to biggest number.
     */
    public T[] insertionSort(T[] arr) {
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                int j = i - 1;
                T temp = arr[i];
                while (j >= 0 && temp.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;
            }
        }

        return arr;
    }

    public T[] mergeSort(T[] arr) {

        if (arr.length > 1) {
            int mid = arr.length / 2;
            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            mergeSort(left, right, arr);
        }

        return arr;
    }

    private void mergeSort(T[] left, T[] right, T[] original) {
        int leftIndex = 0;
        int rightIndex = 0;
        int originalIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {

            if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
                original[originalIndex] = left[leftIndex];
                leftIndex++;
            } else {
                original[originalIndex] = right[rightIndex];
                rightIndex++;
            }

            originalIndex++;
        }

        if (leftIndex == left.length) {

            while (rightIndex < right.length) {
                original[originalIndex] = right[rightIndex];
                originalIndex++;
                rightIndex++;
            }

        } else {
            while (leftIndex < left.length) {
                original[originalIndex] = left[leftIndex];
                originalIndex++;
                leftIndex++;
            }
        }
    }
}
