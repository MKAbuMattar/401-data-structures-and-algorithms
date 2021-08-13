package duckDuckGoose;

import java.util.List;

public class DuckDuckGoose {

    public static String duckDuckGoose(List<String> people, int k) {

        int arrSize = people.size();
        int currIndex = 0;

        while (arrSize > 1) {

            for (int i = 0; i < k; i++) {

                if ((people.get(currIndex) == "_")) {
                    i--;
                } else if ((people.get(currIndex) != "_") && (i == k - 1)) {
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

        for (int i = 0; i < people.size(); i++) {
            String result = people.get(i);
            if (result != "_") {
                return "the winner is: " + result;
            }
        }

        return null;
    }
}
