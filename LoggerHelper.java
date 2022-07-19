package com.sprint.qa.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	private static boolean root=false;
	
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class cls) {
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("log4j.properties");
		root=true;
		return Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
	 Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	 log.info("This is just testing purpose");
	 log.info("This is just testing purpose");
	}
	
}
