package designpatterns.behaviouralpatterns.strategypattern;

public class CreditCardValidationContext {

  private ValidationStrategy strategy;

  public void setStrategy(ValidationStrategy strategy) {
    this.strategy = strategy;
  }

  public boolean validateCard(CreditCard creditCard) {
    return strategy.isValid(creditCard);
  }
}
