package sort;

public class Sort<T extends Comparable<T>> {
    /**
     * Using insertion sort, sorts array items from least to biggest number.
     */
    public T[] insertionSort(T[] arr) {
        if(arr.length > 0){
            for (int i = 1; i < arr.length; i++) {
                int j = i - 1;
                T temp = arr[i];
                while (j >= 0 && temp.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;
            }
            return arr;
        } else {
            return arr;
        }

    }
}
