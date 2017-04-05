package com.xqls.entity.zxw;

public class role {
	private Integer roleid;
	private String rolename;
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public role(Integer roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public role() {
		super();
	}
	@Override
	public String toString() {
		return "role [roleid=" + roleid + ", rolename=" + rolename + "]";
	}
	
}
