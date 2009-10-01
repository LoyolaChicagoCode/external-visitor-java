package edu.luc.cs.cs473.vizex.size;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.cs473.vizex.framework.ConfigurableVisitor;

public class TestSize {

	protected ConfigurableVisitor<MutableInteger> visitor;

	@Before
	public void setUp() throws Exception {
		visitor = new SizeVisitor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInteger() {
		assertEquals(1, visitor.visit(7).get());
	}

	@Test
	public void testString() {
		assertEquals(1, visitor.visit("abc").get());
	}

	@Test
	public void testLinkedList() {
		final List<String> l = new LinkedList<String>();
		l.add("hello");
		l.add("world");
		// 1 dummy header node, 2 real nodes, 2 strings, 2 equal integers
		// (counts as 1) = 6
		assertEquals(6, visitor.visit(l).get());
	}
}
