package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleStackQueueBased<T> implements Stack<T> {

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
}
