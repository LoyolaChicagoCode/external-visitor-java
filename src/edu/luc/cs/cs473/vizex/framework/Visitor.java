package edu.luc.cs.cs473.vizex.framework;

/**
 * An external visitor on an object.
 * 
 * @param <Result>
 *            the result type of the visitor
 */
public interface Visitor<Result> {

	/**
	 * Visits the object o and returns a result.
	 * 
	 * @param o
	 *            the object
	 * @return the result
	 */
	Result visit(Object o);
}
