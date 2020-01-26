package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;
import expressiontree.composite.CompositeSubtractNode;

/**
 * @class Subtract
 * @brief Defines a node in the parse tree for the binary subtract operator non-terminal expression.
 */
class Subtract extends Operator {

  private int addSubPrecedence;

  /** Ctor */
  public Subtract(int addSubPrecedence) {
    super(null, null, addSubPrecedence);
    this.addSubPrecedence = addSubPrecedence;
  }

  /** Adds precedence to its current value. */
  public int addPrecedence(int accumulatedPrecedence) {
    precedence = addSubPrecedence + accumulatedPrecedence;
    return precedence;
  }

  /** Method for building a @a Subtract node. */
  ComponentNode build() {
    return new CompositeSubtractNode(left.build(), right.build());
  }

  /** Returns the current precedence. */
  public int precedence() {
    return precedence;
  }
}
