package designpatterns.behaviouralpatterns.templatepattern;

public abstract class AbstractBusinessService {

  protected abstract void configure();

  protected void assignEvents() {}

  protected abstract void build();

  protected void saveData() {}

  final void render() {
    build();
    configure();
  }

  final void nextAction() {
    saveData();
    assignEvents();
  }
}
