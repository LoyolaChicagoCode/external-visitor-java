package edu.luc.cs.cs473.vizex.treeview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.Test;

import edu.luc.cs.cs473.vizex.framework.ConfigurableVisitor;

public abstract class TestVisualizer {

	protected ConfigurableVisitor<DefaultMutableTreeNode> visitor;

	@Test
	public void testInteger() {
		DefaultMutableTreeNode t = visitor.visit(7);
		assertTrue(t.isLeaf());
		assertEquals(7, t.getUserObject());
	}

	@Test
	public void testString() {
		DefaultMutableTreeNode t = visitor.visit("hello");
		assertTrue(t.isLeaf());
		assertEquals("\"hello\"", t.getUserObject());
	}

	@Test
	public void testStringArray() {
		DefaultMutableTreeNode t = visitor.visit(new String[] { "asdf" });
		assertEquals(1, t.getChildCount());
		DefaultMutableTreeNode c = (DefaultMutableTreeNode) t.getFirstChild();
		assertEquals(0, c.getUserObject());
		assertEquals(1, c.getChildCount());
		DefaultMutableTreeNode l = (DefaultMutableTreeNode) c.getFirstChild();
		assertEquals("\"asdf\"", l.getUserObject());
	}

	@Test
	public void testIntArray() {
		DefaultMutableTreeNode t = visitor.visit(new int[] { 1, 2, 3 });
		assertEquals(3, t.getChildCount());
		DefaultMutableTreeNode c = (DefaultMutableTreeNode) t.getLastChild();
		assertEquals(2, c.getUserObject());
		assertEquals(1, c.getChildCount());
		DefaultMutableTreeNode l = (DefaultMutableTreeNode) c.getFirstChild();
		assertEquals(3, l.getUserObject());
	}

	@Test
	public void testObject1() {
		DefaultMutableTreeNode t = visitor.visit(new Object() {
			@SuppressWarnings("unused")
			String s = "abc";
		});
		assertTrue(t.getChildCount() >= 1);
		DefaultMutableTreeNode c = (DefaultMutableTreeNode) t.getFirstChild();
		String s = (String) c.getUserObject();
		assertEquals(".s", s.substring(s.length() - 2, s.length()));
		assertEquals(1, c.getChildCount());
		DefaultMutableTreeNode l = (DefaultMutableTreeNode) c.getFirstChild();
		assertEquals("\"abc\"", l.getUserObject());
	}

	@Test
	public void testObject2() throws Exception {
		DefaultMutableTreeNode t = visitor.visit(new C());
		assertEquals(2, t.getChildCount());
		DefaultMutableTreeNode c1 = (DefaultMutableTreeNode) t.getFirstChild();
		DefaultMutableTreeNode c2 = (DefaultMutableTreeNode) t.getLastChild();
		String s1 = (String) c1.getUserObject();
		String s2 = (String) c2.getUserObject();
		assertEquals(".r", s1.substring(s1.length() - 2, s1.length()));
		assertEquals(".r", s2.substring(s2.length() - 2, s2.length()));
		assertEquals(1, c1.getChildCount());
		DefaultMutableTreeNode l1 = (DefaultMutableTreeNode) c1.getFirstChild();
		assertEquals(3, l1.getUserObject());
		DefaultMutableTreeNode l2 = (DefaultMutableTreeNode) c2.getFirstChild();
		assertEquals(7, l2.getUserObject());
	}

	@Test
	public void testList() {
		List<String> l = new LinkedList<String>();
		l.add("hello");
		l.add("world");
		DefaultMutableTreeNode t = visitor.visit(l);
		assertEquals(3, t.getChildCount());
		DefaultMutableTreeNode n0 = (DefaultMutableTreeNode) t.getChildAt(0)
				.getChildAt(0).getChildAt(0).getChildAt(0);
		assertNull(n0.getUserObject());
		DefaultMutableTreeNode n1 = (DefaultMutableTreeNode) t.getChildAt(0)
				.getChildAt(0).getChildAt(1).getChildAt(0).getChildAt(0)
				.getChildAt(0);
		assertEquals("\"hello\"", n1.getUserObject());
		DefaultMutableTreeNode n2 = (DefaultMutableTreeNode) t.getChildAt(0)
				.getChildAt(0).getChildAt(1).getChildAt(0).getChildAt(1)
				.getChildAt(0).getChildAt(0).getChildAt(0);
		assertEquals("\"world\"", n2.getUserObject());
	}
}

class P {
	int r = 7;
}

class C extends P {
	@SuppressWarnings("hiding")
	int r = 3;
}
