public class Main {
  public static void main(String[] args) {

    int[] arr = { 89, 2354, 3546, 23, 10, -923, 823, -12 };
    int[] reverseArr = new int[arr.length];
    int tempLength = arr.length;

    for (int i = 0; i < arr.length; i++) {
      reverseArr[tempLength - 1] = arr[i];
      tempLength = tempLength - 1;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.println(reverseArr[i]);
    }

  }
}