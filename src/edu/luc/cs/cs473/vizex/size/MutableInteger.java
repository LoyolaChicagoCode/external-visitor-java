package edu.luc.cs.cs473.vizex.size;

/**
 * A simple, not very complete implementation of a mutable integer suitable for
 * accumulating results into incrementally.
 */
public class MutableInteger {

	private int value;

	/**
	 * Constructs a mutable integer with initial value 0.
	 */
	public MutableInteger() {
		value = 0;
	}

	/**
	 * Constructs a mutable integer with the given initial value.
	 * 
	 * @param the
	 *            initial value
	 */
	public MutableInteger(final int value) {
		this.value = value;
	}

	/**
	 * Returns the current value.
	 * 
	 * @return the current value
	 */
	public int get() {
		return value;
	}

	/**
	 * Adds the specified value to the current value.
	 * 
	 * @param delta
	 *            the value to be added
	 */
	public void add(final int delta) {
		value += delta;
	}
}
