package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;
import expressiontree.composite.CompositeDivideNode;

/**
 * @class Divide
 * @brief Defines a node in the parse tree for the binary divide operator non-terminal expression.
 */
class Divide extends Operator {

  static final int mulDivPrecedence = 2;

  /** Ctor */
  public Divide() {
    super(null, null, mulDivPrecedence);
  }

  /** Returns the current precedence. */
  public int precedence() {
    return precedence;
  }

  /** Adds precedence to its current value. */
  public int addPrecedence(int accumulatedPrecedence) {
    return precedence = mulDivPrecedence + accumulatedPrecedence;
  }

  /** Method for building a @a Divide node. */
  ComponentNode build() {
    return new CompositeDivideNode(left.build(), right.build());
  }
}
