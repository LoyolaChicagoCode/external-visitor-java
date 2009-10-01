package edu.luc.cs.cs473.vizex.framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestConfigurableVisitor {

	private ConfigurableVisitor<String> visitor;

	@Before
	public void setUp() throws Exception {
		visitor = new ConfigurableVisitor<String>();
	}

	@After
	public void tearDown() throws Exception {
		visitor = null;
	}

	@Test
	public void testNoBranches() {
		try {
			visitor.visit("abc");
			fail("should throw excption: no visitor found for class String");
		} catch (RuntimeException ex) {
		}
	}

	@Test
	public void testSimple() {
		visitor.addBranch(String.class, new Visitor<String>() {
			public String visit(Object o) {
				return "\"" + o + "\"";
			}
		});
		visitor.addBranch(Integer.class, new Visitor<String>() {
			public String visit(Object o) {
				return o.toString();
			}
		});
		visitor.addBranch(Number.class, new Visitor<String>() {
			public String visit(Object o) {
				return "<someNumber>";
			}
		});
		visitor.addBranch(Object.class, new Visitor<String>() {
			public String visit(Object o) {
				return "<someOtherObject>";
			}
		});
		assertEquals("\"abc\"", visitor.visit("abc"));
		assertEquals("123", visitor.visit(123));
		assertEquals("<someNumber>", visitor.visit(123.45));
		assertEquals("<someOtherObject>", visitor.visit(this));
	}

	@Test
	public void testSimple2() {
		visitor.addBranch(String.class, new Visitor<String>() {
			public String visit(Object o) {
				return "\"" + o + "\"";
			}
		});
		visitor.addBranch(Number.class, new Visitor<String>() {
			public String visit(Object o) {
				return "<someNumber>";
			}
		});
		visitor.addBranch(Integer.class, new Visitor<String>() {
			public String visit(Object o) {
				return o.toString();
			}
		});
		visitor.addBranch(Object.class, new Visitor<String>() {
			public String visit(Object o) {
				return "<someOtherObject>";
			}
		});
		assertEquals("\"abc\"", visitor.visit("abc"));
		assertEquals("<someNumber>", visitor.visit(123));
		assertEquals("<someNumber>", visitor.visit(123.45));
		assertEquals("<someOtherObject>", visitor.visit(this));
	}

	@Test
	public void testRemoveBranch() {
		visitor.addBranch(String.class, new Visitor<String>() {
			public String visit(Object o) {
				return "\"" + o + "\"";
			}
		});
		visitor.removeBranch(String.class);
		try {
			visitor.visit("abc");
			fail("should throw excption: no visitor found for class String");
		} catch (RuntimeException ex) {
		}
	}
}
