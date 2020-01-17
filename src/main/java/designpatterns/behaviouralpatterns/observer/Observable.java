package designpatterns.behaviouralpatterns.observer;

public interface Observable {

  void registerObserver(Observer observer);

  void deregisterObserver(Observer observer);
}
