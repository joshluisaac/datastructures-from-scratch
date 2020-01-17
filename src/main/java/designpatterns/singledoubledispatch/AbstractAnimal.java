package designpatterns.singledoubledispatch;

public abstract class AbstractAnimal implements Animal {

  @Override
  public void makeSound() {}

  @Override
  public void makeSound(Dog dog) {}

  @Override
  public void makeSound(Cat cat) {}
}
