package designpatterns.singledoubledispatch;

public class AnimalRunner {

  public static void main(String[] args) {
    Animal dog = new Dog();
    Animal cat = new Cat();
    dog.makeSound();
    cat.makeSound();

    dog.makeSound(cat);
    cat.makeSound(dog);
  }
}
