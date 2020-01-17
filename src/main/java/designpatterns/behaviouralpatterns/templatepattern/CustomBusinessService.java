package designpatterns.behaviouralpatterns.templatepattern;

public class CustomBusinessService extends AbstractBusinessService {

  @Override
  protected void configure() {
    System.out.println("Running configure");
  }

  @Override
  protected void build() {
    System.out.println("Running build");
  }

  @Override
  protected void assignEvents() {
    System.out.println("Running...assignEvents");
  }

  @Override
  protected void saveData() {
    System.out.println("Running...saveData");
  }
}
