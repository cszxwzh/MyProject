package com.xqls.entity.zxw;

public class SelectPerms {
	//权限树中节点的id属性
	private String id;
	//权限树中节点的name属性
	private String name;
	//权限表中的主键id属性
	private String eid;
	//对应角色表的主键id
	private String rid;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SelectPerms() {
		super();
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public SelectPerms(String id, String name, String eid, String rid) {
		super();
		this.id = id;
		this.name = name;
		this.eid = eid;
		this.rid = rid;
	}
	
}
