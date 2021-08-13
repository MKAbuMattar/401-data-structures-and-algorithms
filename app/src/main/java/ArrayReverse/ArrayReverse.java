package ArrayReverse;

public class ArrayReverse {

  public int[] arrayReverse(int[] arr) {

    int[] reverseArr = new int[arr.length];

    int tempLength = arr.length;

    for (int j : arr) {
      reverseArr[tempLength - 1] = j;
      tempLength = tempLength - 1;
    }

    return reverseArr;
  }
}
