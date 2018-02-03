/*
 *
 */
package com.utility.api;

import java.util.Calendar;
import java.util.Date;

/**
 * The Class JcifsConnectionClass.
 */
public class JcifsConnectionClass
{

	/** The stack trace. */
	private String stackTrace;

	/** The connection time. */
	private Date connectionTime;

	/** The time stamp. */
	private long timeStamp;

	/** The repo path. */
	private String repoPath;

	/** The connection status. */
	private String connectionStatus;

	/**
	 * Instantiates a new jcifs connection class.
	 * @author GS-1629
	 * @param stackTrace the stack trace
	 * @param connectionTime the connection time
	 * @param repoPath the repo path
	 * @param connectionStatus the connection status
	 */
	public JcifsConnectionClass(String stackTrace, Date connectionTime, String repoPath, String connectionStatus)
	{
		this.stackTrace = stackTrace;
		this.connectionTime = connectionTime;
		this.repoPath = repoPath;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(getConnectionTime());
		this.timeStamp = c1.getTimeInMillis();
		this.connectionStatus = connectionStatus;
	}

	/**
	 * Gets the stack trace.
	 * @author GS-1629
	 * @return the stack trace
	 */
	public String getStackTrace()
	{
		return stackTrace;
	}

	/**
	 * Sets the stack trace.
	 * @author GS-1629
	 * @param stackTrace the new stack trace
	 */
	public void setStackTrace(String stackTrace)
	{
		this.stackTrace = stackTrace;
	}

	/**
	 * Gets the connection time.
	 * @author GS-1629
	 * @return the connection time
	 */
	public Date getConnectionTime()
	{
		return connectionTime;
	}

	/**
	 * Sets the connection time.
	 * @author GS-1629
	 * @param connectionTime the new connection time
	 */
	public void setConnectionTime(Date connectionTime)
	{
		this.connectionTime = connectionTime;
	}

	/**
	 * Gets the active since.
	 * @author GS-1629
	 * @return the active since
	 */
	public String getActiveSince()
	{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		Calendar c1 = Calendar.getInstance();
		c1.setTime(getConnectionTime());

		long activeMiliSeconds = c.getTimeInMillis() - c1.getTimeInMillis();

		long ms = activeMiliSeconds % 1000;
		activeMiliSeconds = activeMiliSeconds / 1000;
		long s = activeMiliSeconds % 60;
		activeMiliSeconds = activeMiliSeconds / 60;
		long m = activeMiliSeconds % 60;
		activeMiliSeconds = activeMiliSeconds / 60;
		long h = activeMiliSeconds % 60;
		activeMiliSeconds = activeMiliSeconds / 60;
		long d = activeMiliSeconds % 24;
		return d + " Days, " + h + " Hours, " + m + " Minutes, " + s + " Seconds, " + ms + " Miliseconds.";
	}

	/**
	 * Gets the time stamp.
	 * @author GS-1629
	 * @return the time stamp
	 */
	public long getTimeStamp()
	{
		return timeStamp;
	}

	/**
	 * Sets the time stamp.
	 * @author GS-1629
	 * @param timeStamp the new time stamp
	 */
	public void setTimeStamp(long timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	/**
	 * Gets the repo path.
	 * @author GS-1629
	 * @return the repo path
	 */
	public String getRepoPath()
	{
		return repoPath;
	}

	/**
	 * Sets the repository path.
	 * @author GS-1629
	 * @param repoPath the new repository path
	 */
	public void setRepoPath(String repoPath)
	{
		this.repoPath = repoPath;
	}

	/**
	 * Gets the connection status.
	 * @author GS-1629
	 * @return the connection status
	 */
	public String getConnectionStatus()
	{
		return connectionStatus;
	}

	/**
	 * Sets the connection status.
	 * @author GS-1629
	 * @param connectionStatus the new connection status
	 */
	public void setConnectionStatus(String connectionStatus)
	{
		this.connectionStatus = connectionStatus;
	}

}
