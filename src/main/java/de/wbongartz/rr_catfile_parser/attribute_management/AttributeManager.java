package de.wbongartz.rr_catfile_parser.attribute_management;

import java.util.*;

/**
 * @author Wolfgang Bongartz
 *
 */
public class AttributeManager implements IAttributeContainer 
{
	private Map<String,Object> _attributeMap;
	
	/**
	 * 
	 */
	public AttributeManager() 
	{
		_attributeMap = new TreeMap<String,Object>();
	}

	/* (non-Javadoc)
	 * @see attributeManagement.IAttributeContainer#addAttribute(java.lang.String, java.lang.Object)
	 */
	@Override
	public void addAttribute(String name, Object value) {
		_attributeMap.put(name, value);
	}

	/* (non-Javadoc)
	 * @see attributeManagement.IAttributeContainer#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String name) {
		return _attributeMap.get(name);
	}

}
