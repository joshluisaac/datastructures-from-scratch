package datastructure;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleStackQueueBasedTest {

  private Stack<String> stack = new SimpleStackQueueBased<>();

  @Test
  public void shouldReturn100_WhenStackIsPopped() {
    stack.push("100");
    stack.push("200");
    stack.push("300");
    stack.push("400");
    stack.push("900");
    assertThat(stack.pop()).isEqualTo("900");
  }

  @Test
  public void shouldReturn5_AsStackSize() {
    stack.push("100");
    stack.push("200");
    stack.push("300");
    stack.push("400");
    stack.push("900");
    assertThat(stack.size()).isEqualTo(5);
  }

  @Test
  public void shouldReturn4_AsStackSize() {
    stack.push("100");
    stack.push("200");
    stack.push("300");
    stack.push("400");
    stack.push("900");
    stack.pop();
    assertThat(stack.size()).isEqualTo(4);
  }
}
