package edu.luc.cs.cs473.vizex.dfs;

import java.lang.reflect.Field;

/**
 * A handler for traversing an object tree with methods for the various
 * situations encountered during the traversal.
 * 
 * @param <Result>
 *            the result type of the associated visitor
 */
public interface TraversalHandler<Result> {

	/**
	 * Handles a null object.
	 * 
	 * @return the corresponding result
	 */
	Result onNull();

	/**
	 * Handles a previously visited object.
	 * 
	 * @param o
	 *            the object
	 * @return the corresponding result
	 * 
	 */
	Result onVisited(Object o);

	/**
	 * Handles a previously unvisited object.
	 * 
	 * @param o
	 *            the object
	 * @return the corresponding result
	 */
	Result onUnvisited(Object o);

	/**
	 * Handles an array element and adds the element-specific result to the
	 * cumulative result.
	 * 
	 * @param result
	 *            the cumulative result
	 * @param index
	 *            the index of this element in the array
	 * @param elementResult
	 *            the element-specific result
	 */
	void onArrayElement(Result result, int index, Result elementResult);

	/**
	 * Handles an field and adds the field-specific result to the cumulative
	 * result.
	 * 
	 * @param result
	 *            the cumulative result
	 * @param field
	 *            the object representing the field
	 * @param fieldResult
	 *            the field-specific result
	 */
	void onField(Result result, Field field, Result fieldResult);

	/**
	 * Handles an inaccessible field and adds a field-specific result to the
	 * cumulative result.
	 * 
	 * @param result
	 *            the cumulative result
	 * @param field
	 *            the object representing the field
	 */
	void onInaccessibleField(Result result, Field field);
}
