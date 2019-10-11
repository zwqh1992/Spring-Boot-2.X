package cn.zwqh.springboot.model;

public class Hero {

	private Long id;//英雄ID
	private String heroCode;//英雄编码
	private String heroName;//英雄名称
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHeroCode() {
		return heroCode;
	}
	public void setHeroCode(String heroCode) {
		this.heroCode = heroCode;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	
	
}
