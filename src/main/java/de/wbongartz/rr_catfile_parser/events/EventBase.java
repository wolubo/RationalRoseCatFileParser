package de.wbongartz.rr_catfile_parser.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * @author Wolfgang Bongartz
 *
 */
public abstract class EventBase {
	
	private static ArrayList<EventListener> _listeners = new ArrayList<EventListener>();
	
	/**
	 * 
	 */
	private EventBase() {
	}
	
	
	/**
	 * 
	 */
	public static final synchronized void fire(Object eventObject)
	{
		Class<?> eventClass = eventObject.getClass();
		
		for(EventListener l: _listeners)
		{
			if(l.getEvent()==eventClass)
			{
				Object receiver = l.getReceiver();
				Method method = l.getMethod();
				try {
					method.invoke(receiver, eventObject);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static final synchronized void addListener(Class<?> event, Object receiver, String methodName)
	{
		Class<?> receiverClass = receiver.getClass();
		Method m=null;
		try {
			m = receiverClass.getMethod(methodName, event);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		EventListener newListener = new EventListener(event, receiver, m);
		_listeners.add(newListener);
	}

}
