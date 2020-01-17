package designpatterns.behaviouralpatterns.visitorpattern;

public interface Visitor {

  void visit(Necessity necessity);

  void visit(Tobacco tobacco);

  void visit(Alcohol alcohol);
}
