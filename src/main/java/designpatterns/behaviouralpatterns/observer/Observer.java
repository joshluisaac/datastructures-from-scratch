package designpatterns.behaviouralpatterns.observer;

public interface Observer {
  void update();

  void subscribeTo(Publisher publisher);

  void unSubscribe(Publisher publisher);
}
