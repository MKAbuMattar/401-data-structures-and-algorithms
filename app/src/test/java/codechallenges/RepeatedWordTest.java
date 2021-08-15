package codechallenges;

import RepeatedWord.RepeatedWord;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RepeatedWordTest {

  RepeatedWord word;
  private String empty;
  private String oneWordRepeated;
  private String multiWordRepeated;

  @Before
  public void init() {
    word = new RepeatedWord();
    empty = "";
    oneWordRepeated = "Once upon a time, there was a brave princess who...";
    multiWordRepeated = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";
  }

  @Test
  public void TestRepeatedWordEmpty(){
    assertNull(word.repeatedWord(empty));
  }

  @Test
  public void TestRepeatedWordOneWordRepeated(){
    assertEquals("a", word.repeatedWord(oneWordRepeated));
  }

  @Test
  public void TestRepeatedWordMultiWordRepeated(){
    assertEquals("summer", word.repeatedWord(multiWordRepeated));
  }

  @Test
  public void TestRepeatedWordsEmpty(){
    assertEquals("Linked list is empty",word.repeatedWords(empty));
  }

  @Test
  public void TestRepeatedWordsOneWordRepeated(){
    assertEquals("{a}-> NULL", word.repeatedWords(oneWordRepeated));
  }

  @Test
  public void TestRepeatedWordsMultiWordRepeated(){
    assertEquals("{was}-> {summer}-> {the}-> {I}-> NULL", word.repeatedWords(multiWordRepeated));
  }
}
