package de.wbongartz.rr_catfile_parser.rose_model;

import java.util.List;

/**
 * @author Wolfgang Bongartz
 *
 */
public class PropertyList extends ModelObject
{
	@SuppressWarnings("unused")
	private List<Attribute> _attributes;
	
	public void setAttributes(List<Attribute> attributes)
	{
		_attributes = attributes;
	}

}
