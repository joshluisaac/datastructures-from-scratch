package designpatterns.behaviouralpatterns.visitorpattern;

import designpatterns.behaviouralpatterns.visitorpattern.visitors.HolidayTaxVisitor;
import designpatterns.behaviouralpatterns.visitorpattern.visitors.TaxRebateVisitor;
import designpatterns.behaviouralpatterns.visitorpattern.visitors.TaxVisitor;

public class VisitorRunner {

  public static void main(String[] args) {
    Visitor taxVisitor = new TaxVisitor();
    Visitor taxRebateVisitor = new TaxRebateVisitor();
    Visitor holidayTaxVisitor = new HolidayTaxVisitor();

    Visitable alcohol = new Alcohol();
    alcohol.accept(taxVisitor);
  }
}
