package ArrayShift;

public class ArrayShift {

  public int[] arrayShift(int[] arr, int num) {
    int[] newArr = new int[arr.length + 1];

    for (int i = 0; i < newArr.length; i++) {
      if (arr.length % 2 == 0) {
        if (i < arr.length / 2) {
          newArr[i] = arr[i];
        } else if (i == arr.length / 2) {
          newArr[i] = num;
        } else {
          newArr[i] = arr[i - 1];
        }
      } else {
        if (i < arr.length / 2 + 1) {
          newArr[i] = arr[i];
        } else if (i == arr.length / 2 + 1) {
          newArr[i] = num;
        } else {
          newArr[i] = arr[i - 1];
        }
      }
    }

    return newArr;
  }
}
