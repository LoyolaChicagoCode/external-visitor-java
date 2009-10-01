package edu.luc.cs.cs473.vizex.size;

import edu.luc.cs.cs473.vizex.dfs.TraversalVisitor;
import edu.luc.cs.cs473.vizex.framework.ConfigurableVisitor;

/**
 * A visitor that computes the size of an object graph. Strings and scalars each
 * contribute one to the total size.
 */
public class SizeVisitor extends ConfigurableVisitor<MutableInteger> {

	public SizeVisitor() {
		addBranch(String.class, new StringVisitor());
		TraversalVisitor<MutableInteger> objectVisitor = new TraversalVisitor<MutableInteger>();
		objectVisitor.setRootVisitor(this);
		objectVisitor.setTraversalHandler(new ObjectHandler());
		addBranch(Object.class, objectVisitor);
	}
}
