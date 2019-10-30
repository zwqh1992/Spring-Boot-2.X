package cn.zwqh.springboot.model;

import java.io.Serializable;

public class CronTrigger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 880141459783509786L;
	
	private Long id;//任务id
	private String cron;//cron表达式
	private String createTime;//创建时间
	private String updateTime;//更新时间
	private boolean isDeleted=false;//删除状态
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
