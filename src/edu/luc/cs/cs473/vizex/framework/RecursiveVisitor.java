package edu.luc.cs.cs473.vizex.framework;

/**
 * A recursive visitor that has to be aware of a root visitor.
 * 
 * @param <Result>
 *            the result type of the visitor
 */
public interface RecursiveVisitor<Result> extends Visitor<Result> {

	/**
	 * Sets the root visitor of this recursive visitor.
	 * 
	 * @param root
	 *            the root visitor
	 */
	void setRootVisitor(Visitor<Result> root);
}
