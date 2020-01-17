package designpatterns.behaviouralpatterns.templatepattern;

public class CustomRunner {

  public static void main(String[] args) {
    AbstractBusinessService businessService = new CustomBusinessService();
    businessService.render();
    businessService.nextAction();
  }
}
