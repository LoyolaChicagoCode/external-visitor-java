package edu.luc.cs.cs473.vizex.treeview;

import org.junit.After;
import org.junit.Before;

public class TestVisualizerStandard extends TestVisualizer {

	@Before
	public void setUp() throws Exception {
		visitor = new TreeVisualizer();
	}

	@After
	public void tearDown() throws Exception {
		visitor = null;
	}
}