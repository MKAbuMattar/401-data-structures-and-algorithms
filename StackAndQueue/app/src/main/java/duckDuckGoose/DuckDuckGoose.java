package duckDuckGoose;

import java.util.Arrays;

public class DuckDuckGoose {

    public static String DuckDuckGoose(String[] arr, int k){

        int arrLength = arr.length;
        String c = "";
        int temp = 0;
        int i = 0;

        while (arr.length > i) {

            if (k > 0) {
                temp += k;

                if (temp > arrLength) {
                    temp -= arrLength;
                }
            }

            if(arr[temp-1] != "__"){

                c = arr[temp-1];

                i++;

                arr[temp-1] = "__";

                System.out.println(Arrays.toString(arr));
            }

        }

        return c;


    }
}
