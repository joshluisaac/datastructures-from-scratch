package designpatterns.behaviouralpatterns.strategypattern;

public class VisaCardStrategy extends AbstractValidationStrategy {
  @Override
  public boolean isValid(CreditCard CreditCard) {
    System.out.println("Running VisaCardStrategy");
    return false;
  }
}
