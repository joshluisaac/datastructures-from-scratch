package designpatterns.behaviouralpatterns.observer;

import lombok.SneakyThrows;

public class ObserverRunner {

  @SneakyThrows
  public static void main(String[] args) {

    SubjectModel publisher = new SubjectModel();

    // Observer macObserver = new MacObserver(model);

    // Observer windowsObserver = new WindowsObserver(model);

    Observer subscriber = new LinuxObserver("Joshua Uzo");
    subscriber.subscribeTo(publisher);

    Thread.sleep(10000);

    publisher.uploadBook("Object-Oriented Analysis and Design By Grady Booch1");
    Thread.sleep(10000);
    publisher.uploadBook("Object-Oriented Analysis and Design By Grady Booch2");
    Thread.sleep(10000);
    publisher.uploadBook("Object-Oriented Analysis and Design By Grady Booch3");

    subscriber.unSubscribe(publisher);
    Thread.sleep(10000);
    publisher.uploadBook("Object-Oriented Analysis and Design By Grady Booch4");
  }
}
