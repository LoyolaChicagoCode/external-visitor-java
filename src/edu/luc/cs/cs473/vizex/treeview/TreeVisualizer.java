package edu.luc.cs.cs473.vizex.treeview;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import edu.luc.cs.cs473.vizex.dfs.TraversalVisitor;
import edu.luc.cs.cs473.vizex.framework.ConfigurableVisitor;

/**
 * A graphical visualizer for trees based on Swing.
 */
public class TreeVisualizer extends ConfigurableVisitor<DefaultMutableTreeNode> {

	public TreeVisualizer() {
		addBranch(String.class, new StringVisitor());
		addBranch(Number.class, new ShallowVisitor());
		TraversalVisitor<DefaultMutableTreeNode> objectVisitor = new TraversalVisitor<DefaultMutableTreeNode>();
		objectVisitor.setRootVisitor(this);
		objectVisitor.setTraversalHandler(new ObjectHandler());
		addBranch(Object.class, objectVisitor);
	}

	/**
	 * Visualizes the given tree node in a Swing frame.
	 * 
	 * @param node
	 *            the tree node
	 */
	public static void visualize(TreeNode node) {
		JTree t = new JTree(node);
		JFrame f = new JFrame("Object Visitor");
		f.setContentPane(t);
		f.pack();
		f.setVisible(true);
	}

	/**
	 * Visits and visualizes the object graph rooted at the given object.
	 */
	public void visitAndVisualize(Object o) {
		TreeVisualizer.visualize(visit(o));
	}
}
