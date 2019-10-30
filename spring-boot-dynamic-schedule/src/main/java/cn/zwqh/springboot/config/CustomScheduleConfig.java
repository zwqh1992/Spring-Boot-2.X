package cn.zwqh.springboot.config;

import java.util.Date;
import java.util.concurrent.Executors;
import java.lang.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import cn.zwqh.springboot.common.DateUtil;
import cn.zwqh.springboot.dao.CronTriggerDao;

@Configuration
public class CustomScheduleConfig implements SchedulingConfigurer {

	@Autowired
	private CronTriggerDao cronTriggerDao;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		//设定一个长度为10的定时任务线程池
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
		
		// 上次开始执行时间点后5秒再执行
		taskRegistrar.addFixedRateTask(() -> System.out.println("CustomScheduleConfig执行任务job1=>"
				+ DateUtil.formatDateTime(new Date()) + ",线程：" + Thread.currentThread().getName()), 5000);
		// 上次执行完毕时间点后3秒再执行
		taskRegistrar.addFixedDelayTask(() -> System.out.println("CustomScheduleConfig执行任务job2=>"
				+ DateUtil.formatDateTime(new Date()) + ",线程：" + Thread.currentThread().getName()), 3000);
		// 添加第一个配合数据库动态执行的定时任务
		TriggerTask triggerTask = new TriggerTask(
				// 任务内容.拉姆达表达式
				() -> {
					// 1）添加任务 Runnable
					System.out.println("CustomScheduleConfig执行动态任务job3=>" + DateUtil.formatDateTime(new Date()) + ",线程："
							+ Thread.currentThread().getName());
					// 2）设置执行周期
				}, triggerContext -> {
					// 3）从数据库获取执行周期
					String cron = cronTriggerDao.getCronTriggerById(1L);
					if (cron != null) {
						// 4）返回执行周期（Date）
						return new CronTrigger(cron).nextExecutionTime(triggerContext);
					} else {
						return null;
					}

				});
		taskRegistrar.addTriggerTask(triggerTask);
		// 添加第二个配合数据库动态执行的定时任务
		TriggerTask triggerTask2 = new TriggerTask(
				// 任务内容.拉姆达表达式
				() -> {
					// 1）添加任务 Runnable
					System.out.println("CustomScheduleConfig执行动态任务job4=>" + DateUtil.formatDateTime(new Date()) + ",线程："
							+ Thread.currentThread().getName());
					// 2）设置执行周期
				}, triggerContext -> {
					// 3）从数据库获取执行周期
					String cron = cronTriggerDao.getCronTriggerById(2L);
					if (cron != null) {
						// 4）返回执行周期（Date）
						return new CronTrigger(cron).nextExecutionTime(triggerContext);
					} else {
						return null;
					}

				});
		taskRegistrar.addTriggerTask(triggerTask2);

	}

}
