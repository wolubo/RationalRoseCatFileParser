package de.wbongartz.rr_catfile_parser.rose_model;

/**
 * @author Wolfgang Bongartz
 *
 */
public interface INamedElement {
	void setName(String name);
	String getName();

	void setVisibility(VisibilityKind visibility);
	VisibilityKind getVisibility();
}
