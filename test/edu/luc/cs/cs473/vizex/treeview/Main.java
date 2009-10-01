package edu.luc.cs.cs473.vizex.treeview;

import java.util.LinkedList;
import java.util.List;

import edu.luc.cs.cs473.vizex.framework.Visitor;

/**
 * This main class produces the screenshots found on the course site.
 */
public class Main {

	public static void main(String[] args) {
		final TreeVisualizer visitor = new TreeVisualizer();

		final Visitor<Void> visualizer = new Visitor<Void>() {
			public Void visit(Object o) {
				visitor.visitAndVisualize(o);
				return null;
			}
		};
		doVisit(visualizer);
	}

	public static void doVisit(Visitor<Void> visualizer) {
		visualizer.visit(7);
		visualizer.visit("hello");
		visualizer.visit(new String[] { "asdf" });
		visualizer.visit(new int[] { 1, 2, 3 });
		visualizer.visit(new Object() {
			@SuppressWarnings("unused")
			String s = "abc";
		});

		class P {
			@SuppressWarnings("unused")
			int r = 7;
		}
		class C extends P {
			@SuppressWarnings( { "hiding", "unused" })
			int r = 3;
		}
		visualizer.visit(new C());

		final List<String> l = new LinkedList<String>();
		l.add("hello");
		l.add("world");
		visualizer.visit(l);
	}
}
