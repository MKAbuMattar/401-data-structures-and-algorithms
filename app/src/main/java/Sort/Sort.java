package Sort;

import java.util.Arrays;

public class Sort<T extends Comparable<T>>  {

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
            merge(left, right, arr);
        }

        return arr;
    }

    private void merge(T[] left, T[] right, T[] original) {
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

    public T[] quicksort(T[] arr, int left, int right) {
        if(left < right) {
            // Partition the array by setting the position of the pivot value
            int partitionIndex = partition(arr, left, right);
            // Sort the left
            quicksort(arr, left, partitionIndex - 1);
            // Sort the right
            quicksort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(T[] arr, int left, int right) {
        // set a pivot value as a point of reference
        T pivot = arr[right];

        // create a variable to track the largest index of numbers lower than the defined pivot
        int low = left - 1;

        for(int i = left; i < right; i++) {
            if(arr[i].compareTo(pivot) < 0) {
                low++;
                swap(arr, i, low);
            }
        }

        // place the value of the pivot location in the middle.
        // all numbers smaller than the pivot are on the left, larger on the right.
        swap(arr, right, low + 1);

        // return the pivot index point
        return low + 1;
    }

    private void swap(T[] arr, int i, int low) {
        T temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }
}
