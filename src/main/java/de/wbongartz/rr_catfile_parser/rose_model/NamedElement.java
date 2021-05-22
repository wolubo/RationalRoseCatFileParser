package de.wbongartz.rr_catfile_parser.rose_model;

/**
 * @author Wolfgang Bongartz
 *
 */
public class NamedElement implements INamedElement
{
	
	private String _name;
	private VisibilityKind _visibility;
	
	/**
	 * 
	 */
	public NamedElement()
	{
		_name = null;
		_visibility = null;
	}

	/**
	 * 
	 * @param name
	 * @param visibility
	 */
	public NamedElement(String name, VisibilityKind visibility)
	{
		_name = name;
		_visibility = visibility;
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		_name = name;
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#getName()
	 */
	@Override
	public String getName() {
		return _name;
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#setVisibility(uml.VisibilityKind)
	 */
	@Override
	public void setVisibility(VisibilityKind visibility) {
		_visibility = visibility;
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#getVisibility()
	 */
	@Override
	public VisibilityKind getVisibility() {
		return _visibility;
	}

}
