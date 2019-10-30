package cn.zwqh.springboot.dao;

public interface CronTriggerDao {
	/**
	 * 根据id获取cron表达式
	 * @param id
	 * @return
	 */
	String getCronTriggerById(Long id);

}
