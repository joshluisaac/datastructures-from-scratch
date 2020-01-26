package expressiontree.interpreter;

import expressiontree.composite.ComponentNode;

/**
 * @class UnaryOperator
 * @brief Defines a node in the parse tree for unary operator non-terminal expressions.
 */
public abstract class UnaryOperator extends Symbol {
  /** Ctor */
  UnaryOperator(Symbol right, int precedence) {
    super(null, right, precedence);
  }

  /** Abstract method for building a @a UnaryOperator node. */
  abstract ComponentNode build();
}
