package edu.luc.cs.cs473.vizex.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

import edu.luc.cs.cs473.vizex.dfs.TraversalHandler;
import edu.luc.cs.cs473.vizex.dfs.TraversalVisitor;

/**
 * A configurable visitor whose configuration is provided as a properties
 * object.
 */
public class PropertiesConfigurableVisitor<Result> extends
		ConfigurableVisitor<Result> {

	// TODO your job (see below)
	
	/**
	 * The default properties file name.
	 */
	public static final String DEFAULT_PROP_FILE = "default.properties";

	private static final long serialVersionUID = -3461398584493464710L;

	private boolean debug = true;

	/**
	 * Indicates whether or not to generate debugging output.
	 * 
	 * @param debug
	 */
	public void setDebug(final boolean debug) {
		this.debug = debug;
	}

	/**
	 * Constructs an empty explorer map.
	 */
	public PropertiesConfigurableVisitor() {
	}

	/**
	 * Loads an explorer map from a properties file.
	 * 
	 * @param propFileName
	 *            the file name
	 */
	public void loadFromFile(final String propFileName) throws IOException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		final FileReader in = new FileReader(propFileName);
		final StreamTokenizer tokenizer = new StreamTokenizer(
				new BufferedReader(in));
		tokenizer.eolIsSignificant(true);
		// lines are properties of the form
		// objectClass=visitorClass
		// or
		// objectClass=visitorClass handlerClass
		int token = tokenizer.nextToken();
		while (token != StreamTokenizer.TT_EOF) {
			if (token == StreamTokenizer.TT_WORD) {
				final String className = tokenizer.sval;
				if (debug)
					System.out.print(className + " -> ");
				// TODO create class object for object class 
				token = tokenizer.nextToken();
				token = tokenizer.nextToken();
				final String visitorName = tokenizer.sval;
				if (debug)
					System.out.print(visitorName);
				// TODO create instance of visitor class
				token = tokenizer.nextToken();
				// check if there is a handler class
				if (token == StreamTokenizer.TT_WORD) {
					final String handlerName = tokenizer.sval;
					if (debug)
						System.out.print(" " + handlerName);
					// TODO create instance of traversal handler class
					// and connect it to the visitor instance
					token = tokenizer.nextToken();
				}
				token = tokenizer.nextToken();
				if (debug)
					System.out.println();
				// TODO add the branch for this line
			}
		}
		in.close();
		if (debug)
			System.out.println(branches);
	}

	/**
	 * Loads an explorer map from the default properties file.
	 */
	public void loadFromFile() throws IOException, ClassNotFoundException,
			IllegalAccessException, InstantiationException {
		loadFromFile(DEFAULT_PROP_FILE);
	}
}
