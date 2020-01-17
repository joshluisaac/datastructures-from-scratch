package designpatterns.behaviouralpatterns.observer;

public class MacObserver extends AbstractObserver {

  public MacObserver(String subscriberName) {
    this.subscriberName = subscriberName;
  }

  @Override
  public void update() {
    System.out.println("MacObserver - notified of model state...: " + publisher.getBookTitle());
  }

  @Override
  public void subscribeTo(Publisher publisher) {
    this.publisher = publisher;
    publisher.registerObserver(this);
  }

  @Override
  public void unSubscribe(Publisher publisher) {
    publisher.deregisterObserver(this);
  }
}
