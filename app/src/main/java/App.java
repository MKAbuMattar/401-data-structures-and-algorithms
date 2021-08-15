import HashTable.types.HashTable;
import RepeatedWord.RepeatedWord;

import java.util.Arrays;

public class App {
  public static void main(String[] args) {

    RepeatedWord word = new RepeatedWord();

    String text = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";

    System.out.println(word.repeatedWord(text));

    System.out.println(word.repeatedWords(text));

  }
}
