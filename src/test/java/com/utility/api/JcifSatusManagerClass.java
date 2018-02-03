/*
 *
 */
package com.utility.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * The Class JcifSatusManagerClass.
 * will use for connection between client machine to file server for verify file is successfully upload or not
 */
public class JcifSatusManagerClass
{

	/** The instance. */
	private static JcifSatusManagerClass instance = null;

	/** The jcifs con map list. */
	private final ConcurrentHashMap<String, JcifsConnectionClass> jcifsConMapList = new ConcurrentHashMap<>();

	/**
	 * Instantiates a new jcif satus manager class.
	 */
	JcifSatusManagerClass()
	{
	}

	/**
	 * Gets the single instance of JcifSatusManagerClass.
	 * @author GS-1629
	 * @return single instance of JcifSatusManagerClass
	 */
	public static JcifSatusManagerClass getInstance()
	{
		if (instance == null)
		{
			instance = new JcifSatusManagerClass();
		}
		return instance;
	}

	/**
	 * Adds the jcifs connection.
	 * @author GS-1629
	 * @param jcifsCon the jcifs con
	 */
	public void addJcifsConnection(JcifsConnectionClass jcifsCon)
	{
		jcifsConMapList.put(jcifsCon.toString() + "_" + jcifsCon.getTimeStamp(), jcifsCon);
	}

	/**
	 * Removes the jcifs connection.
	 * @author GS-1629
	 * @param jcifsCon the jcifs con
	 */
	public void removeJcifsConnection(JcifsConnectionClass jcifsCon)
	{
		jcifsConMapList.remove(jcifsCon.toString() + "_" + jcifsCon.getTimeStamp());
	}

	/**
	 * Gets the jcifs con map list.
	 * @author GS-1629
	 * @return the jcifs con map list
	 */
	public ConcurrentMap<String, JcifsConnectionClass> getJcifsConMapList()
	{
		return jcifsConMapList;
	}
}
