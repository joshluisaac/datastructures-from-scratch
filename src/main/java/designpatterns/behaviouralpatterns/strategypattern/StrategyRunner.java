package designpatterns.behaviouralpatterns.strategypattern;

import java.time.LocalDate;

public class StrategyRunner {
  public static void main(String[] args) {
    CreditCardValidationContext context = new CreditCardValidationContext();
    context.setStrategy(new AmexCardStrategy());
    CreditCard creditCard =
        CreditCard.builder().cardNo("").cvv("").expiryDate(LocalDate.now()).build();
    context.validateCard(creditCard);
  }
}
