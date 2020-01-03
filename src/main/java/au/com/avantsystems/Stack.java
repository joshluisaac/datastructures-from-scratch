package au.com.avantsystems;

public interface Stack<T> {

  void push(T t);

  T pop();

  int size();
}
