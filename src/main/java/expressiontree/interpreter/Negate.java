package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;
import expressiontree.composite.CompositeNegateNode;

/**
 * @class Negate
 * @brief Defines a node in the parse tree for unary minus operator non-terminal expression.
 */
class Negate extends UnaryOperator {

  private int negatePrecedence;

  /** Ctor */
  public Negate(int negatePrecedence) {
    super(null, negatePrecedence);
    this.negatePrecedence = negatePrecedence;
  }

  /** Adds precedence to its current value. */
  public int addPrecedence(int accumulatedPrecedence) {
    precedence = negatePrecedence + accumulatedPrecedence;
    return precedence;
  }

  /** Method for building a @a Negate node. */
  ComponentNode build() {
    return new CompositeNegateNode(right.build());
  }

  /** Returns the current precedence. */
  public int precedence() {
    return precedence;
  }
}
