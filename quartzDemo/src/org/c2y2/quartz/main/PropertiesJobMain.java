package org.c2y2.quartz.main;

import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.c2y2.quartz.util.PropertiesUtil;
import org.c2y2.quartz.util.ReflectionUtil;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class PropertiesJobMain {
	private static Logger logger = Logger.getLogger(PropertiesJobMain.class);
	
	public static void main(String[] args) {
		Properties properties = PropertiesUtil.getProperties();
		for (Entry<Object, Object> entry: properties.entrySet()) {
			String key = entry.getKey()+"";
			if(key.endsWith("JobClass")){
				/**
				 * 1,获取job类
				 * 2，获取job执行度
				 */
				String job_name = entry.getValue()+"";
				
				//获取job
				JobDetail jobDetail = JobBuilder.newJob(ReflectionUtil.getClass(job_name))
						.withIdentity(key+"jobDetail_1", key+"_group_1")
						.build();
				
				//执行trigger
				String cron = properties.getProperty(key+"Cron");
				Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail)
						 .withIdentity(key+"jrigger_1", key+"_group_1")
						 .withSchedule(CronScheduleBuilder.cronSchedule(cron))
						.build();
				
				//获取调度实例
				SchedulerFactory sf  = new StdSchedulerFactory();
				Scheduler scheduler;
				try {
					scheduler = sf.getScheduler();
					scheduler.scheduleJob(jobDetail, trigger);
					scheduler.start();
				} catch (SchedulerException e) {
					logger.error("",e);
				}
			}
		}
	}
}
