package designpatterns.behaviouralpatterns.strategypattern;

public class AmexCardStrategy extends AbstractValidationStrategy {

  @Override
  public boolean isValid(CreditCard CreditCard) {
    System.out.println("Running AmexCardStrategy");
    return false;
  }
}
