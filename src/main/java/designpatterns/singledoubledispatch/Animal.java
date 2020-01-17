package designpatterns.singledoubledispatch;

public interface Animal {

  void makeSound();

  void makeSound(Dog dog);

  void makeSound(Cat cat);

  void makeSound(Animal animal);
}
