package designpatterns.behaviouralpatterns.strategypattern;

public class MasterCardStrategy extends AbstractValidationStrategy {

  @Override
  public boolean isValid(CreditCard CreditCard) {
    System.out.println("Running MasterCardStrategy");
    return false;
  }
}
