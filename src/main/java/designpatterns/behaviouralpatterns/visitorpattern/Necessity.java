package designpatterns.behaviouralpatterns.visitorpattern;

public class Necessity implements Visitable {

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
