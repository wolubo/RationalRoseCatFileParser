package de.wbongartz.rr_catfile_parser.attribute_management;

/**
 * @author Wolfgang Bongartz
 *
 */
public interface IAttributeContainer {
	void addAttribute(String name, Object value);
	Object getAttribute(String name);
}
