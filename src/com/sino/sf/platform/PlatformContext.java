package com.sino.sf.platform;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class PlatformContext {
   
	
    private  static   ConcurrentHashMap goalbalContext;
	private  static  ThreadLocal<HashMap> httpRequestContext=new ThreadLocal<HashMap>();
	
	static{
		goalbalContext=new ConcurrentHashMap();
		goalbalContext.put("commonRpcContext", new ThreadLocal<String>());
	}
	
	public  static   void  putGoalbalContext(Object k,Object v)
	{
		goalbalContext.put(k, v);
	}
	public  static   Object getGoalbalContext(Object k)
	{
		return goalbalContext.get(k);
	}
	public  static  <T> T getGoalbalContext(Object k,Class<T> cls)
	{
		return (T) getGoalbalContext( k);
	}
	
	public  static   void clearHttpRequestContext()
	{

		httpRequestContext.remove();
	}
	
	public static   void  putHttpRequestContext(Object k,Object v)
	{
		HashMap context=httpRequestContext.get();
		if(context==null)
		{
			context=new HashMap();
			httpRequestContext.set(context);
		}
		context.put(k, v);
	
	}
	public static void removeHttpRequestContext(Object k)
	{
		HashMap context=httpRequestContext.get();
		if(context!=null)
		{
			context.remove(k);
		}
		 
	}
	public  static  Object getHttpRequestContext(Object k)
	{
		HashMap context=httpRequestContext.get();
		if(context==null)
		{
//			context=new HashMap();
//			httpRequestContext.set(context);
			return null;
		}
		else
		{
			return context.get(k);
		}
		
	
	}
	
	public  static  <T> T getHttpRequestContext(Object k,Class<T> cls)
	{
		return (T) getHttpRequestContext( k);
	}
	
	public  static  <T> T getHttpRequestContext(Object k,Object defaultObject,Class<T> cls)
	{
		Object v=getHttpRequestContext( k);
		if(v==null)
			v=defaultObject;
		return (T) v;
	}



	public static HttpServletRequest getHttpServletRequest()
	{
		return getHttpRequestContext(HttpServletRequest.class,HttpServletRequest.class);
	}
	public static HttpServletResponse getHttpServletResponse()
	{
		return getHttpRequestContext(HttpServletResponse.class,HttpServletResponse.class);
	}
	

	
}
