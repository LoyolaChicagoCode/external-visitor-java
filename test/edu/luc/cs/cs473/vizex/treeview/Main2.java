package edu.luc.cs.cs473.vizex.treeview;

import javax.swing.tree.DefaultMutableTreeNode;

import edu.luc.cs.cs473.vizex.framework.PropertiesConfigurableVisitor;
import edu.luc.cs.cs473.vizex.framework.Visitor;

/**
 * This main class produces the screenshots found on the course site.
 */
public class Main2 {

	public static void main(String[] args) throws Exception {
		final PropertiesConfigurableVisitor<DefaultMutableTreeNode> visitor = new PropertiesConfigurableVisitor<DefaultMutableTreeNode>();
		visitor.loadFromFile();
		
		final Visitor<Void> visualizer = new Visitor<Void>() {
			public Void visit(Object o) {
				TreeVisualizer.visualize(visitor.visit(o));
				return null;
			}
		};
		
		Main.doVisit(visualizer);
	}
}
