package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;
import expressiontree.composite.LeafNode;

/**
 * @class Symbol
 * @brief Defines a node in the parse tree for number terminal expressions.
 */
class Number extends Symbol {
  /** Value of Number. */
  private int item;

  private int numberPrecedence;

  /** Ctor */
  public Number(String input, int numberPrecedence) {
    super(null, null, numberPrecedence);
    item = Integer.parseInt(input);
    this.numberPrecedence = numberPrecedence;
  }

  /** Ctor */
  public Number(int input, int numberPrecedence) {
    super(null, null, numberPrecedence);
    item = input;
  }

  /** Adds numberPrecedence to the current accumulatedPrecedence value. */
  public int addPrecedence(int accumulatedPrecedence) {
    precedence = numberPrecedence + accumulatedPrecedence;
    return precedence;
  }

  /** Method for returning precedence level (higher value means higher precedence). */
  public int precedence() {
    return precedence;
  }

  /** Builds a @a LeadNode. */
  ComponentNode build() {
    return new LeafNode(item);
  }
}
