package com.xqls.entity.zxw;

public class TreeResult {
	private String id;
	private String pId;
	private String name;
	private Boolean open;
	private Boolean isParent;
	private Boolean checked;
	private String eid;
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public TreeResult() {
		super();
	}
	public TreeResult(String id, String pId, String name, Boolean open,
			Boolean isParent) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	
	
}
