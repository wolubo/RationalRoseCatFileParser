package de.wbongartz.rr_catfile_parser.rose_model;

/**
 * @author Wolfgang Bongartz
 *
 */
public class ModelObject 
{
	@SuppressWarnings("unused")
	private String _quid;
	
	@SuppressWarnings("unused")
	private String _name;
	
	/**
	 * 
	 */
	public ModelObject()
	{
	}

	/**
	 * 
	 * @param quid
	 */
	public void setQuid(String quid)
	{
		_quid = quid;
	}
	
	/**
	 * Gives the object a name.
	 * @param name NULL to delete the current name.
	 */
	public void setName(String name)
	{
		_name = name;
	}
	
}
