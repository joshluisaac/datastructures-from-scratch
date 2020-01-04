package au.com.avantsystems;

import java.lang.reflect.Array;

public class SimpleStackArrayBased<T> implements Stack<T> {

  private T[] contents;
  private int stackPointer;

  @SuppressWarnings("unchecked")
  public SimpleStackArrayBased(Class<T> tClass, int capacity) {
    contents = (T[]) Array.newInstance(tClass, capacity);
  }

  @Override
  public void push(T t) {
    checkFullStack();
    contents[stackPointer++] = t;
  }

  @Override
  public T pop() {
    checkEmptyStack();
    return contents[--stackPointer];
  }

  @Override
  public int size() {
    return stackPointer;
  }

  private void checkFullStack() {
    if (stackPointer >= contents.length) {
      throw new IllegalArgumentException("Cannot push to a full stack.");
    }
  }

  private void checkEmptyStack() {
    if (stackPointer == 0) {
      throw new IllegalArgumentException("Cannot pop from empty stack.");
    }
  }
}
