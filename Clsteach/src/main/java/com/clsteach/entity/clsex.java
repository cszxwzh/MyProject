package com.clsteach.entity;

import java.util.List;
/**
 * 
 * @author cszxw
 *用于在cls中查询各个阶段的老师信息的时候使用
 */
public class clsex extends cls {

private List<stageex> stagelist;

public List<stageex> getStagelist() {
	return stagelist;
}

public void setStagelist(List<stageex> stagelist) {
	this.stagelist = stagelist;
}
	
}
