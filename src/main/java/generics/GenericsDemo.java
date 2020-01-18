package generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
  private String name;
}

class Lemon extends Fruit {}

class SweetLemon extends Lemon {}

class AcidicLemon extends Lemon {}

class AlkalineLemon extends Lemon {}

public class GenericsDemo {

  public static void main(String[] args) {
    // all of these guys can read and write their respective types.
    List<SweetLemon> sweetLemons = new ArrayList<>();
    List<AcidicLemon> acidicLemons = new ArrayList<>();
    List<AlkalineLemon> alkalineLemons = new ArrayList<>();
    List<Lemon> lemons = new ArrayList<>();

    List<? extends Lemon> upperBoundLemons = new ArrayList<>();
    // You can only read lemon type from this or will otherwise have to cast
    Lemon lemon = upperBoundLemons.get(1);

    // Still you can only read lemon type from this even if it is pointing to a list of sweet
    // lemons.
    upperBoundLemons = sweetLemons;
    upperBoundLemons = acidicLemons;
    upperBoundLemons = alkalineLemons;
    upperBoundLemons = lemons;
    Lemon l = upperBoundLemons.get(2);

    List<? super Lemon> lowerBoundLemons = new ArrayList<>();

    lowerBoundLemons.add(new Lemon());
    lowerBoundLemons.add(new AcidicLemon());
    lowerBoundLemons.add(new SweetLemon());
    lowerBoundLemons.add(new AlkalineLemon());

    lowerBoundLemons = lemons;

    // You can only read lemon type from this.
    Object lemon1 = lowerBoundLemons.get(1);
  }
}
