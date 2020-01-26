package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;
import expressiontree.composite.CompositeAddNode;

/**
 * @class Add
 * @brief Defines a node in the parse tree for the binary add operator non-terminal expression.
 */
class Add extends Operator {

  private int addSubPrecedence;

  /** Ctor */
  public Add(int addSubPrecedence) {
    super(null, null, addSubPrecedence);
    this.addSubPrecedence = addSubPrecedence;
  }

  /** Adds Precedence to its current value. */
  public int addPrecedence(int accumulatedPrecedence) {
    precedence = addSubPrecedence + accumulatedPrecedence;
    return precedence;
  }

  /** Method for building an @a Add node. */
  ComponentNode build() {
    return new CompositeAddNode(left.build(), right.build());
  }

  /** Returns the current precedence. */
  public int precedence() {
    return precedence;
  }
}
