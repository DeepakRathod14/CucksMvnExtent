/*
 * This class is for implementing all API calls
 * related to ReportRequestPage.
 */
package com.api.pageobjects;

import java.util.Collection;
import java.util.List;

import com.api.beans.Post;
import com.api.beans.Users;
import com.utility.api.BaseApiClass;

/**
 * The Class ReportRequestApiPage.
 * This class is for implementing all API calls
 * related to ReportRequestPage.
 */
public class ReportRequestApiPage extends BaseApiClass{

	/** The report request api. */
	private static ReportRequestApiPage reportRequestApi = null;
	private static BaseApiClass baseApi = null;
	/**
	 * Instantiates a new report request api page.
	 *
	 * @author GS-1629
	 * Instantiates a new report request api page.
	 */
	private ReportRequestApiPage()
	{
		// It is for restricting creating object of ReportRequest from outside of class
	}

	/**
	 * Gets the single instance of ReportRequestApiPage.
	 *@author GS-1629
	 * @return single instance of ReportRequestApiPage
	 */
	public static synchronized ReportRequestApiPage getInstance()
	{
		if (reportRequestApi == null)
		{
			reportRequestApi = new ReportRequestApiPage();
		}
		return reportRequestApi;
	}


	public static void getUserAPI() throws Exception
	{
		baseApi = BaseApiClass.getInstance();
		Users example1 = new Users();
		Collection<Users> exmpl =  baseApi.setConnectionParam("https://jsonplaceholder.typicode.com/users", "GET", 200,"",null,example1,false,"application/json","application/json");
		for(Users example : exmpl)
		{
			System.out.println(example.getId());
			System.out.println(example.getName());
			System.out.println(example.getUsername());
			System.out.println(example.getEmail());
			System.out.println(example.getPhone());
			System.out.println(example.getWebsite());
			System.out.println("========================");

		}
	}

	public static void getPostsAPI() throws Exception
	{
		baseApi = BaseApiClass.getInstance();
		Post post = new Post();
		List<Post> postResponce =  baseApi.setConnectionParam("https://jsonplaceholder.typicode.com/posts", "GET", 200,"",null,post,false,"application/json","application/json");
		for(Post example : postResponce)
		{
			System.out.println(example.getId());
			System.out.println(example.getTitle());
			System.out.println(example.getUserId());
			System.out.println(example.getBody());
		}
	}
	public static void main(String[] args) throws Exception {
		getUserAPI();

	}
}