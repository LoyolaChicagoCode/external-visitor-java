package edu.luc.cs.cs473.vizex.treeview;

import java.lang.reflect.Field;

import javax.swing.tree.DefaultMutableTreeNode;

import edu.luc.cs.cs473.vizex.dfs.TraversalHandler;

/**
 * A handler that builds a tree representation of the object being traversed.
 */
public class ObjectHandler implements TraversalHandler<DefaultMutableTreeNode> {

	// TODO your job
	
	public static final String PRIVATE_VALUE = "<inaccessible>";

	@Override
	public DefaultMutableTreeNode onUnvisited(final Object node) {
		return null;
	}

	@Override
	public void onArrayElement(final DefaultMutableTreeNode result,
			final int index, final DefaultMutableTreeNode elementResult) {
	}

	@Override
	public void onField(final DefaultMutableTreeNode result, final Field field,
			final DefaultMutableTreeNode fieldResult) {
	}

	@Override
	public void onInaccessibleField(final DefaultMutableTreeNode result,
			final Field field) {
		// DONE as an example
		DefaultMutableTreeNode fieldNode = new DefaultMutableTreeNode(field
				.getDeclaringClass().getName()
				+ "." + field.getName());
		fieldNode.add(new DefaultMutableTreeNode(PRIVATE_VALUE));
		result.add(fieldNode);
	}

	@Override
	public DefaultMutableTreeNode onNull() {
		// DONE as an example
		return new DefaultMutableTreeNode(null);
	}

	@Override
	public DefaultMutableTreeNode onVisited(final Object node) {
		return null;
	}

}
