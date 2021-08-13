class Main {
  public static int binarySearch(int arr[], int number, int arrLength, int callback) {
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

  public static void main(String args[]) {
    int arr[] = { -131, -82, 0, 27, 42, 68, 179 };
    int number = 42;
    int result = binarySearch(arr, number, arr.length - 1, 0);
    if (result == -1) {
      System.out.println("");
    } else {
      System.out.println("Result: " + result);
    }
  }
}
