package RepeatedWord;

import HashTable.types.HashTable;
import LinkedList.types.LinkedList;
import java.util.*;

public class RepeatedWord {

  private static final String PATTERN = "\\W+";

  public String repeatedWord(String str){
    String[] words = str.split(PATTERN);
    HashTable<String> wordTable = new HashTable<>();
    for(String word : words) {
      if(wordTable.contains(word)){
        return word;
      } else {
        wordTable.add(word);
      }
    }
    return null;
  }

  public String repeatedWords(String str) {
    int count;
    LinkedList<String> temp = new LinkedList<>();
    String[] words = str.split(PATTERN);

    for (int i = 0; i < words.length; i++) {
      count = 1;

      for (int j = i + 1; j < words.length; j++) {
        if (words[i].equals(words[j])) {
          count++;
          words[j] = "0";
        }
      }

      if (count > 1 && !Objects.equals(words[i], "0")) {
        temp.add(words[i]);
      }

    }
    return temp.toString();
  }
}
