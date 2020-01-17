package designpatterns.behaviouralpatterns.visitorpattern;

public interface Visitable {

  void accept(Visitor visitor);
}
