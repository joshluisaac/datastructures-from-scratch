package designpatterns.singledoubledispatch;

public class Dog extends AbstractAnimal {

  @Override
  public void makeSound() {
    System.out.println("Barking");
  }

  @Override
  public void makeSound(Dog dog) {
    System.out.println("Dog interacting with dog");
  }

  @Override
  public void makeSound(Cat cat) {
    System.out.println("Dog interacting with cat");
  }

  @Override
  public void makeSound(Animal animal) {
    System.out.println("Dog interacting with animal");
  }
}
