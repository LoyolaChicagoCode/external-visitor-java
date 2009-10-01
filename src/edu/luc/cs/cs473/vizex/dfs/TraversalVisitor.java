package edu.luc.cs.cs473.vizex.dfs;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import edu.luc.cs.cs473.vizex.framework.RecursiveVisitor;
import edu.luc.cs.cs473.vizex.framework.Visitor;

/**
 * An external visitor that performs an application-independent deep traversal
 * of an object graph. During this traversal, it invokes the
 * application-specific handler methods for the various situations encountered
 * during the traversal. The visitor is single-use, meaning that one should
 * create a different instance for each object graph.
 */
public class TraversalVisitor<Result> implements RecursiveVisitor<Result>,
		TraversalHandlerAware<Result> {

	// TODO your job
	
	/**
	 * The application-specific traversal handler.
	 */
	private TraversalHandler<Result> handler;

	@Override
	public void setTraversalHandler(final TraversalHandler<Result> handler) {
		this.handler = handler;
	}

	/**
	 * The root visitor used to visit subobjects recursively.
	 */
	private Visitor<Result> root;

	@Override
	public void setRootVisitor(final Visitor<Result> root) {
		this.root = root;
	}

	/**
	 * Performs a depth-first traversal of the object graph. Invokes the
	 * application-specific handler methods as appropriate. Static fields are
	 * ignored.
	 * 
	 * @param o
	 *            the root of the object graph
	 */
	public Result visit(final Object o) {
		// TODO your job
		// Check the object for null.
		// Make sure to visit each object only once in-depth.
		// Don't visit the visitor itself, in case this happens.
		// If the object is an array, visit each array element
		// recursively using the root visitor.
		// Otherwise, visit all declared non-static fields
		// recursively using the root visitor, then check superclass.

		return handler.onNull();
	}
}