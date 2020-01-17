package designpatterns.behaviouralpatterns.visitorpattern.visitors;

import designpatterns.behaviouralpatterns.visitorpattern.Alcohol;
import designpatterns.behaviouralpatterns.visitorpattern.Necessity;
import designpatterns.behaviouralpatterns.visitorpattern.Tobacco;
import designpatterns.behaviouralpatterns.visitorpattern.Visitor;

public class TaxVisitor implements Visitor {

  @Override
  public void visit(Necessity necessity) {}

  @Override
  public void visit(Tobacco tobacco) {}

  @Override
  public void visit(Alcohol alcohol) {
    System.out.println("Computing tax amount for alcohol related item");
  }
}
