package duckDuckGoose;

import java.util.List;
import java.util.Objects;

public class DuckDuckGoose {

    public static String duckDuckGoose(List<String> people, int k) {

        int arrSize = people.size();
        int currIndex = 0;

        while (arrSize > 1) {

            for (int i = 0; i < k; i++) {

                if ((Objects.equals(people.get(currIndex), "_"))) {
                    i--;
                } else if ((!Objects.equals(people.get(currIndex), "_")) && (i == k - 1)) {
                    people.set(currIndex, "_");
                    arrSize--;
                }

                currIndex++;

                if (currIndex == people.size()) {
                    currIndex = 0;
                }
            }

            System.out.println(people);
        }

        for (String result : people) {
            if (!Objects.equals(result, "_")) {
                return "the winner is: " + result;
            }
        }

        return null;
    }
}
