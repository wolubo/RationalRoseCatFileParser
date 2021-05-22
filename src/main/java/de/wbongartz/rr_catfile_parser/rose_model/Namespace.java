package de.wbongartz.rr_catfile_parser.rose_model;

/**
 * @author Wolfgang Bongartz
 *
 */
public class Namespace extends NamedElement {

	/**
	 * 
	 */
	public Namespace() {
		super();
	}

	/**
	 * @param name
	 * @param visibility
	 */
	public Namespace(String name, VisibilityKind visibility) {
		super(name, visibility);
	}

}
