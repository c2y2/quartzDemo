package org.c2y2.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class IntervalOutPrint implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("定时输出任务2");
		System.out.println("没10秒钟执行一次");
	}
}
