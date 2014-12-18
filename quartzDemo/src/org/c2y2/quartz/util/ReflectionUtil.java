package org.c2y2.quartz.util;

import org.apache.log4j.Logger;
import org.quartz.Job;


public class ReflectionUtil {
	private static Logger logger = Logger.getLogger(ReflectionUtil.class);
	@SuppressWarnings("unchecked")
	public static Class<? extends Job> getClass(String job_name){
		Class<? extends Job> clazz = null;
		try {
			clazz = (Class<? extends Job>) Class.forName(job_name);
		} catch (ClassNotFoundException e) {
			logger.error("",e);
		}
		return clazz;
	}
}
