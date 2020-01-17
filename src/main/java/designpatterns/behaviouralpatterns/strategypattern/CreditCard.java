package designpatterns.behaviouralpatterns.strategypattern;

import java.time.LocalDate;
import lombok.Builder;

// @Value
@Builder
public class CreditCard {
  String cardNo;
  LocalDate expiryDate;
  String cvv;
}
