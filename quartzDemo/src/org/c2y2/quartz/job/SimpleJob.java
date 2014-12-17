package org.c2y2.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job{

	@Override
	public void execute(JobExecutionContext executionContext) throws JobExecutionException {
		System.out.println(executionContext.getJobRunTime());
		System.out.println(executionContext.getFireInstanceId());
	}

}
