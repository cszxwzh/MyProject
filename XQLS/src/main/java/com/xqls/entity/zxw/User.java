package com.xqls.entity.zxw;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private Integer roleid;
    
    private Integer blockid;

    private String blocknum;
    
    public String getBlocknum() {
		return blocknum;
	}

	public void setBlocknum(String blocknum) {
		this.blocknum = blocknum;
	}

	private Integer warnlevel;
    
    private String phonenum;
    
    public Integer getBlockid() {
		return blockid;
	}

	public void setBlockid(Integer blockid) {
		this.blockid = blockid;
	}

	public Integer getWarnlevel() {
		return warnlevel;
	}

	public void setWarnlevel(Integer warnlevel) {
		this.warnlevel = warnlevel;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}