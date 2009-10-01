package edu.luc.cs.cs473.vizex.treeview;

import javax.swing.tree.DefaultMutableTreeNode;

import edu.luc.cs.cs473.vizex.framework.Visitor;

/**
 * A visitor that creates a leaf containing the String representation of an
 * object with added quotes.
 */
public class StringVisitor implements Visitor<DefaultMutableTreeNode> {

	public DefaultMutableTreeNode visit(final Object o) {
		return new DefaultMutableTreeNode("\"" + o + "\"");
	}
}
