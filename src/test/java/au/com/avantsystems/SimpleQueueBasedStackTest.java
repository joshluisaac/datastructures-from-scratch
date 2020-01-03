package au.com.avantsystems;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SimpleQueueBasedStackTest {

    private Stack<String> stack = new SimpleQueueBasedStack<>();

    @Test
    void shouldReturn100_WhenStackIsPopped(){
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.push("400");
        stack.push("900");
        assertThat(stack.pop()).isEqualTo("900");
    }

    @Test
    void shouldReturn5_AsStackSize(){
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.push("400");
        stack.push("900");
        assertThat(stack.size()).isEqualTo(5);
    }

    @Test
    void shouldReturn4_AsStackSize(){
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.push("400");
        stack.push("900");
        stack.pop();
        assertThat(stack.size()).isEqualTo(4);
    }

}
