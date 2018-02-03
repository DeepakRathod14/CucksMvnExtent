/*
 *
 */
package com.utility.api;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * The Class JcifsManagerClass.
 */
public class JcifsManagerClass
{

	/** The logger. */
	static Logger logger = Logger.getLogger(JcifsManagerClass.class);

	/**
	 * Start jcifs connection.
	 * @author GS-1629
	 * @param repoPath the repo path
	 * @param connectionStatus the connection status
	 * @return the jcifs connection class
	 */
	public static JcifsConnectionClass startJcifsConnection(String repoPath, String connectionStatus)
	{
		JcifsConnectionClass jcifsConnection = null;
		try
		{
			jcifsConnection = new JcifsConnectionClass(getStackTrace(), new Date(), repoPath, connectionStatus);
			JcifSatusManagerClass.getInstance().addJcifsConnection(jcifsConnection);

		}
		catch (Exception e)
		{
			logger.info("Exception:-", e);
		}
		return jcifsConnection;
	}

	/**
	 * End jcifs connection.
	 * @author GS-1629
	 * @param jcifsConnection the jcifs connection
	 */
	public static void endJcifsConnection(JcifsConnectionClass jcifsConnection)
	{
		try
		{
			if (jcifsConnection != null)
			{
				Date connectionTime = jcifsConnection.getConnectionTime();

				Date releaseTime = new Date();
				JcifSatusManagerClass.getInstance().removeJcifsConnection(jcifsConnection);
				Calendar connectionCal = Calendar.getInstance();
				connectionCal.setTime(connectionTime);
				Calendar releaseCal = Calendar.getInstance();
				releaseCal.setTime(releaseTime);

			}
		}
		catch (Exception e)
		{
			logger.info("Exception:-", e);
		}
	}

	/**
	 * Gets the stack trace.
	 * @author GS-1629
	 * @return the stack trace
	 */
	private static String getStackTrace()
	{
		StringBuilder retStr = new StringBuilder();
		StackTraceElement[] eList = null;
		eList = Thread.currentThread().getStackTrace();
		if (eList != null)
		{
			for (int i = 3; i < 9 && i < eList.length; i++)
			{
				retStr.append(eList[i].getClassName() + "." + eList[i].getMethodName() + ":" + eList[i].getLineNumber() + "<br/>");
			}
		}
		return retStr.toString();
	}
}
