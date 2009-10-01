package edu.luc.cs.cs473.vizex.treeview;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.After;
import org.junit.Before;

import edu.luc.cs.cs473.vizex.framework.PropertiesConfigurableVisitor;

public class TestVisualizerProperties extends TestVisualizer {

	@Before
	public void setUp() throws Exception {
		visitor = new PropertiesConfigurableVisitor<DefaultMutableTreeNode>();
		((PropertiesConfigurableVisitor<DefaultMutableTreeNode>) visitor).loadFromFile();
	}

	@After
	public void tearDown() throws Exception {
		visitor = null;
	}
}