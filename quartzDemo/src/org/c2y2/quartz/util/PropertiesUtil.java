package org.c2y2.quartz.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	private static String config = "jobCron.properties";
	private static Properties properties = new Properties();
	private static Logger logger = Logger.getLogger(PropertiesUtil.class);
	static{
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(config));
		} catch (IOException e) {
			logger.error("",e);
		}
	}
	
	public static Properties getProperties(){
		return properties;
	}
}
