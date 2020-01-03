package au.com.avantsystems;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueueBasedStack<T> implements Stack<T> {

  private Queue<T> contents = new LinkedList<>();
  private Queue<T> queueBackup = new LinkedList<>();

  private boolean enqueue(T t) {
    return contents.offer(t);
  }

  private T dequeue() {
    return contents.poll();
  }

  @Override
  public void push(T t) {
    enqueue(t);
  }

  @Override
  public T pop() {
    T t = null;
    int queueSize = contents.size();
    for (int i = 0; i < queueSize; i++) {
      t = dequeue();
      if (i != (queueSize - 1)) {
        queueBackup.offer(t);
      }
    }
    contents = queueBackup;
    return t;
  }

  @Override
  public int size() {
    return contents.size();
  }


    public static void main(String[] args) {

      Stack<String> stack = new SimpleQueueBasedStack<>();
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.push("400");
        System.out.println(stack.size());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.pop());


    }

}
