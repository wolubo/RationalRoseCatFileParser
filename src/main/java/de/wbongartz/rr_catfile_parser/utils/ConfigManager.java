package de.wbongartz.rr_catfile_parser.utils;


/**
 * @author 
 *
 */
public class ConfigManager 
{
	
	private PathMap pathMap;
	
	public ConfigManager(String registryLocation)
	{
		String pathMapEntry = readRegistry(registryLocation);
		pathMap = new PathMap(pathMapEntry);
	}
	
	public PathMap getPathMap()
	{
		return pathMap;
	}

	    /**
	     * 
	     * @param location path in the registry
	     * @return registry entry or null if not found
	     */
	    private String readRegistry(String location)
	    {
	        try {
	            Process process = Runtime.getRuntime().exec("reg query " + '"' + location + '"');

	            java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
	            String result = s.hasNext() ? s.next() : "";	
	            result = result.replace("\r", "");
	            result = result.replace(" REG_SZ ", "");
	            result = result.replace(location, "");
	            while(result.contains("  ")) result = result.replace("  ", " ");
	            result = result.trim();
	            return result;
	        }
	        catch (Exception e) {
	            return null;
	        }

	    }

}
