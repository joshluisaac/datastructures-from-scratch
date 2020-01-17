package designpatterns.behaviouralpatterns.observer;

public abstract class AbstractObserver implements Observer {

  protected String subscriberName;
  protected Publisher publisher;

  public abstract void update();
}
