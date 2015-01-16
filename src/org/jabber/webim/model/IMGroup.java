package org.jabber.webim.model;

public class IMGroup {
	private String name;
	private String description;
	
	public IMGroup() {}
	
	/**
	 * 实例化即时通讯组织
	 * @param name 组名
	 * @param description 描述
	 */
	public IMGroup(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
