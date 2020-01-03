package au.com.avantsystems;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleLinkedListTest {

  private SimpleLinkedList<String> linkedList;

  @BeforeEach
  public void beforeSimpleLinkedListTest() {
    linkedList = new SimpleLinkedList<>();
    linkedList.addFirst("100");
    linkedList.addFirst("200");
    linkedList.addLast("300");
    linkedList.addLast("900");
  }

  @Test
  void shouldReturn200_AsHeadValue() {
    String actualHeadValue = linkedList.getHead();
    assertThat(actualHeadValue).isEqualTo("200");
  }

  @Test
  void shouldReturn900_AsTailValue() {
    String actualTailValue = linkedList.getTail();
    assertThat(actualTailValue).isEqualTo("900");
  }

  @Test
  void shouldReturn_Three_AsIndex_WhenItemExists() {
    linkedList = new SimpleLinkedList<>();
    linkedList.addFirst("100");
    linkedList.addFirst("200");
    linkedList.addFirst("450");
    linkedList.addFirst("300");
    assertThat(linkedList.indexOf("100")).isEqualTo(3);
  }

  @Test
  void shouldReturn_MinusOne_AsIndex_WhenItemNotExists() {
    linkedList = new SimpleLinkedList<>();
    linkedList.addFirst("100");
    linkedList.addFirst("200");
    linkedList.addFirst("450");
    linkedList.addFirst("300");
    assertThat(linkedList.indexOf("4100")).isEqualTo(-1);
  }

  @Test
  void shouldReturn_True_WhenItemExists() {
    linkedList = new SimpleLinkedList<>();
    linkedList.addFirst("100");
    linkedList.addFirst("200");
    linkedList.addFirst("3900");
    assertThat(linkedList.contains("200")).isTrue();
  }

  @Test
  void shouldReturn_False_WhenItemNotExists() {
    linkedList = new SimpleLinkedList<>();
    linkedList.addFirst("100");
    linkedList.addFirst("200");
    linkedList.addFirst("3900");
    assertThat(linkedList.contains("1200")).isFalse();
  }
}
