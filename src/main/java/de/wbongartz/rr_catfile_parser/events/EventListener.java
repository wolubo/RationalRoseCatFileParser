package de.wbongartz.rr_catfile_parser.events;

import java.lang.reflect.Method;

/**
 * @author Wolfgang Bongartz
 *
 */
public class EventListener {
	private Class<?> _event;
	private Object _receiver;
	private Method _method;
	
	public EventListener(Class<?> event, Object receiver, Method method) {
		_event = event;
		_receiver = receiver;
		_method = method;
	}
	
	public Class<?> getEvent()
	{
		return _event;
	}
	
	public Object getReceiver()
	{
		return _receiver;
	}
	
	public Method getMethod()
	{
		return _method;
	}
}
