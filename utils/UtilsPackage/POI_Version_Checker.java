package UtilsPackage;

import java.net.URL;

public class POI_Version_Checker 
{
	public static void main(String[] args)
	{
	ClassLoader classloader = org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
	URL res = classloader.getResource("org/apache/poi/util/POILogger.class");
	String path = res.getPath();
	System.out.println("POI came from " + path);
	}

}
