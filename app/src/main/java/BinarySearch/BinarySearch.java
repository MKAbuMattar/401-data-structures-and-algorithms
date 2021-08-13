package BinarySearch;

public class BinarySearch {

    public int binarySearch(int[] arr, int number, int arrLength, int callback) {
        if (arrLength >= callback) {

            int middle = callback + (arrLength - callback) / 2;

            if (arr[middle] == number) {
                return middle;
            }

            if (arr[middle] > number) {
                return binarySearch(arr, number, middle - 1, callback);
            }

            return binarySearch(arr, number, arrLength, middle + 1);
        }

        return -1;
    }

}
