package edu.luc.cs.cs473.vizex.framework;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A configurable visitor with per-class branches. Each branch is also a
 * visitor. The branches are considered in the order added.
 * 
 * @param <Result>
 *            the result type of the visitor
 */
public class ConfigurableVisitor<Result> implements Visitor<Result> {

	/**
	 * The per-class branches of this configurable visitor.
	 */
	protected final Map<Class<?>, Visitor<Result>> branches = new LinkedHashMap<Class<?>, Visitor<Result>>();

	/**
	 * Adds a branch to this visitor. If the branch visitor is recursive, this
	 * visitor becomes its root visitor.
	 * 
	 * @param c
	 *            the class to whose instances this branch applies
	 * @param w
	 *            the visitor for this branch
	 */
	public void addBranch(final Class<?> c, final Visitor<Result> w) {
		branches.put(c, w);
		if (w instanceof RecursiveVisitor) {
			((RecursiveVisitor<Result>) w).setRootVisitor(this);
		}
	}

	/**
	 * Removes a branch from this visitor.
	 * 
	 * @param c
	 *            the class to whose instances this branch applies
	 */
	public void removeBranch(final Class<?> c) {
		Visitor<Result> w = branches.remove(c);
		if (w instanceof RecursiveVisitor) {
			((RecursiveVisitor<Result>) w).setRootVisitor(null);
		}
	}

	/**
	 * Visits the object based on its class. The per-class branches are
	 * considered in the order they were added.
	 * 
	 * @param the
	 *            object to be visited
	 */
	public Result visit(final Object o) {
		final Class<?> c = o == null ? Object.class : o.getClass();
		for (final Class<?> c2 : branches.keySet()) {
			if (c2.isAssignableFrom(c))
				return branches.get(c2).visit(o);
		}
		throw new UnsupportedOperationException("no branch found for " + c);
	}
}
