package com.sino.sf.platform;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class PlatformSessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent event) {
		 
		//PlatformContext.getGoalbalContext(PlatformHttpSessionListenerPlugin.class,PlatformHttpSessionListenerPlugin.class).sessionCreated(  event);
		System.out.println(new Date() + " == sessionCreated == "+event.getSession().getId());
	}

	 
	public void sessionDestroyed(HttpSessionEvent event) {
		 
		//PlatformContext.getGoalbalContext(PlatformHttpSessionListenerPlugin.class,PlatformHttpSessionListenerPlugin.class).sessionDestroyed(  event);
		System.out.println(new Date() + " === sessionDestroyed == "+event.getSession().getId());
		
	}
}
