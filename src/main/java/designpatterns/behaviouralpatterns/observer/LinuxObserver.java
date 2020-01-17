package designpatterns.behaviouralpatterns.observer;

public class LinuxObserver extends AbstractObserver {

  public LinuxObserver(String subscriberName) {
    this.subscriberName = subscriberName;
  }

  @Override
  public void update() {
    System.out.println("LinuxObserver - notified of model state...: " + publisher.getBookTitle());
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
