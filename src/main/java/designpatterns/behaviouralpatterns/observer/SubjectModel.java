package designpatterns.behaviouralpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectModel implements Publisher {

  // reference to all observers
  private List<Observer> observers = new ArrayList<>();

  private int currentState;
  private int oldState;
  private String bookTitle;

  public int getState() {
    return currentState;
  }

  void setState(int state) {
    oldState = currentState;
    this.currentState = state;
  }

  public void uploadBook(String title) {
    this.bookTitle = title;
    notifyObservers(observers);
  }

  @Override
  public String getBookTitle() {
    return bookTitle;
  }

  /**
   * Adds an observer to the list of observers.
   *
   * @param observer
   */
  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void deregisterObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObserver(Observer observer) {
    observer.update();
  }

  public void notifyObservers(List<Observer> observers) {
    observers.forEach(observer -> notifyObserver(observer));
  }
}
