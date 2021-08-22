package RepeatedWord;


import HashMap.Implement.ImplementHashMap;

import java.util.HashMap;
import java.util.Objects;

public class RepeatedWord {

  private static final String PATTERN = "\\W+";

  public String repeatedWord(String str) {
    String[] words = str.toLowerCase().split(PATTERN);
    ImplementHashMap<String> wordTable = new ImplementHashMap<>();
    for (String word : words) {
      if (wordTable.contains(word)) {
        return word;
      } else {
        wordTable.add(word);
      }
    }
    return null;
  }

  public String repeatedWords(String str) {
    int count;
    HashMap<String, Integer> temp = new HashMap<>();
    String[] words = str.toLowerCase().split(PATTERN);

    for (int i = 0; i < words.length; i++) {
      count = 1;
      for (int j = i + 1; j < words.length; j++) {
        if (words[i].equals(words[j])) {
          count++;
          words[j] = "0";
        }
      }
      if (count >= 1 && !Objects.equals(words[i], "0")) {
        temp.put(words[i], count);
      }
    }
    return temp.toString();
  }

  public String repeatedWordsFrequently(String str) {
    int count;
    HashMap<String, Integer> temp = new HashMap<>();
    String[] words = str.toLowerCase().split(PATTERN);

    for (int i = 0; i < words.length; i++) {
      count = 1;
      for (int j = i + 1; j < words.length; j++) {
        if (words[i].equals(words[j])) {
          count++;
          words[j] = "0";
        }
      }
      if (count > 1 && !Objects.equals(words[i], "0")) {
        temp.put(words[i], count);
      }
    }
    return temp.toString();
  }
}
