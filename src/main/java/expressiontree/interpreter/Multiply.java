package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;
import expressiontree.composite.CompositeMultiplyNode;

/**
 * @class Multiply
 * @brief Defines a node in the parse tree for the binary multiply operator non-terminal expression.
 */
class Multiply extends Operator {

  private int mulDivPrecedence;

  /** Ctor */
  public Multiply(int mulDivPrecedence) {
    super(null, null, mulDivPrecedence);
    this.mulDivPrecedence = mulDivPrecedence;
  }

  /** Adds precedence to its current value. */
  public int addPrecedence(int accumulatedPrecedence) {
    precedence = mulDivPrecedence + accumulatedPrecedence;
    return precedence;
  }

  /** Method for building a @a Multiple node. */
  ComponentNode build() {
    return new CompositeMultiplyNode(left.build(), right.build());
  }

  /** Returns the precedence. */
  public int precedence() {
    return precedence;
  }
}
