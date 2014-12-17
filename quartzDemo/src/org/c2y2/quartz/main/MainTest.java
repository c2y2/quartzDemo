package org.c2y2.quartz.main;

import org.c2y2.quartz.job.SimpleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MainTest {
	public static void main(String[] args) {
		JobDetail job = JobBuilder.newJob(SimpleJob.class).
				withIdentity("JobDetail-1", "SimpleJob")
				.build();
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger_1", "SimpleJob")
				.withSchedule(
						SimpleScheduleBuilder
						.simpleSchedule()
						.withIntervalInMilliseconds(500)//每分钟执行一次
						.withRepeatCount(1))//重复次数(2次 0,1)
				.build();
		
		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Scheduler scheduler = sf.getScheduler();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			
		}
		
	}
}
