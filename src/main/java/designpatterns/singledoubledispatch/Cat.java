package designpatterns.singledoubledispatch;

public class Cat extends AbstractAnimal {

  @Override
  public void makeSound() {
    System.out.println("Meow");
  }

  @Override
  public void makeSound(Dog dog) {
    System.out.println("Cat interacting with dog");
  }

  @Override
  public void makeSound(Cat cat) {
    System.out.println("Cat interacting with cat");
  }

  @Override
  public void makeSound(Animal animal) {
    System.out.println("Cat interacting with animal");
  }
}
