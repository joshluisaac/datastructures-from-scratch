package designpatterns.behaviouralpatterns.observer;

public class WindowsObserver extends AbstractObserver {

  public WindowsObserver(String subscriberName) {
    this.subscriberName = subscriberName;
  }

  @Override
  public void update() {
    System.out.println("WindowsObserver - notified of model state...: " + publisher.getBookTitle());
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
