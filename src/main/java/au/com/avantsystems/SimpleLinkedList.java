package au.com.avantsystems;

public class SimpleLinkedList {

  private class Node {
    String value;
    Node next;

    public Node(String value) {
      this.value = value;
    }
  }

  void addFirst(String item) {
    Node node = new Node(item);
  }
}
