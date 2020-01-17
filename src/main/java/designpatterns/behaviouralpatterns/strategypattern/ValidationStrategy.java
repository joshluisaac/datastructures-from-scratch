package designpatterns.behaviouralpatterns.strategypattern;

public interface ValidationStrategy {

  boolean isValid(CreditCard creditCard);
}
