package de.wbongartz.rr_catfile_parser.events;

/**
 * @author Wolfgang Bongartz
 *
 */
public class NewModelEvent {

	private Object _model;
	
	private NewModelEvent() {
		super();
	}

	/**
	 * 
	 */
	public NewModelEvent(Object model)  {
		super();
		_model = model;
	}

	public Object getModel()
	{
		return _model;
	}
}


