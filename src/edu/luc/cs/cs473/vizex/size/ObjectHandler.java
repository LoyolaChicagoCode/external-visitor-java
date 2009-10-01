package edu.luc.cs.cs473.vizex.size;

import java.lang.reflect.Field;

import edu.luc.cs.cs473.vizex.dfs.TraversalHandler;

/**
 * An object handler that accumulates the sizes of the subgraphs rooted at the
 * children of an object.
 */
class ObjectHandler implements TraversalHandler<MutableInteger> {

	// TODO your job

	/**
	 * Adds the element-specific result to the overall result.
	 */
	@Override
	public void onArrayElement(MutableInteger result, int index,
			MutableInteger elementResult) {
	}

	/**
	 * Adds the field-specific result to the overall result.
	 */
	@Override
	public void onField(MutableInteger result, Field field,
			MutableInteger fieldResult) {
	}

	/**
	 * Adds nothing.
	 */
	@Override
	public void onInaccessibleField(MutableInteger result, Field field) {
	}

	/**
	 * Returns zero.
	 */
	@Override
	public MutableInteger onNull() {
		return new MutableInteger(0);
	}

	/**
	 * Returns one.
	 */
	@Override
	public MutableInteger onUnvisited(Object o) {
		return new MutableInteger(0);
	}

	/**
	 * Returns zero.
	 */
	@Override
	public MutableInteger onVisited(Object o) {
		return new MutableInteger(0);
	}
}
