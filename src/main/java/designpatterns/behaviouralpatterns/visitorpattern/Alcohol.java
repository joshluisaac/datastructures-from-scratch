package designpatterns.behaviouralpatterns.visitorpattern;

/**
 * Alcohol is a visitable object. That is, it can be visited by a visitor. It has an accept method
 * which serves as a dispatch point.
 */
public class Alcohol implements Visitable {

  @Override
  public void accept(Visitor visitor) {
    System.out.println("Computation dispatched to tax visitor calculator");
    visitor.visit(this);
  }
}
