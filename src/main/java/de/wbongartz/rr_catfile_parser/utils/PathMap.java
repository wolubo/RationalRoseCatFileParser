package de.wbongartz.rr_catfile_parser.utils;

import java.util.HashMap;

/**
 * @author 
 *
 */
public class PathMap 
{
	private HashMap<String, String> pathMapEntries;
	
	public PathMap(String pathMapEntry)
	{
		pathMapEntries = new HashMap<String, String>();
		
		String[] entries = pathMapEntry.split("\n");
		for(String entry: entries)
		{
			entry = entry.trim();
			String[] parts = entry.split(" ");
			if(parts.length>1)
			{
				String key = parts[0];
			    String value = parts[1];
			    pathMapEntries.put(key, value);
			}
		}
	}
	
	public String expandPath(String path)
	{
		String retVal = path;
		if(retVal.length()>0 && retVal.charAt(0)=='$')
		{
			int i = retVal.indexOf('\\');
			String key = retVal.substring(1, i);
			String value = pathMapEntries.get(key);
			retVal = value + retVal.substring(i);
		}
		return retVal;
	}
}
