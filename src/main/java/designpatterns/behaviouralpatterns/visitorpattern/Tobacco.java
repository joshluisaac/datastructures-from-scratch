package designpatterns.behaviouralpatterns.visitorpattern;

public class Tobacco implements Visitable {

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
