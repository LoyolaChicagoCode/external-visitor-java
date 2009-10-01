package edu.luc.cs.cs473.vizex.dfs;

/**
 * An interface for objects that require a traversal handler.
 * 
 * @param <Result>
 *            the result type of the associated visitor
 */
public interface TraversalHandlerAware<Result> {

	/**
	 * Injects the traversal handler on which this object depends.
	 * 
	 * @param handler
	 *            the traversal handler
	 */
	void setTraversalHandler(TraversalHandler<Result> handler);
}
