package designpatterns.behaviouralpatterns.strategypattern;

public abstract class AbstractValidationStrategy implements ValidationStrategy {

  public abstract boolean isValid(CreditCard creditCard);
}
