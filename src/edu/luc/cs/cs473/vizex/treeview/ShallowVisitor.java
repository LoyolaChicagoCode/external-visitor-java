package edu.luc.cs.cs473.vizex.treeview;

import javax.swing.tree.DefaultMutableTreeNode;

import edu.luc.cs.cs473.vizex.framework.Visitor;

/**
 * A visitor that creates only a leaf for the given object.
 */
public class ShallowVisitor implements Visitor<DefaultMutableTreeNode> {

	public DefaultMutableTreeNode visit(final Object o) {
		return new DefaultMutableTreeNode(o);
	}
}
