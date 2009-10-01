package edu.luc.cs.cs473.vizex.size;

import edu.luc.cs.cs473.vizex.framework.Visitor;

/**
 * A visitor that counts a String as one.
 */
class StringVisitor implements Visitor<MutableInteger> {

	public MutableInteger visit(final Object o) {
		return new MutableInteger(1);
	}
}
