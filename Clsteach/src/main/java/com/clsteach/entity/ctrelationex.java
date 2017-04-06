package com.clsteach.entity;
/**
 * 
 * @author cszxw
 *用于在分配老师时根据，阶段的id和班级的id去查询teach的信息时装数据时使用
 */
public class ctrelationex extends ctrelation {
	private teach teach;

	public teach getTeach() {
		return teach;
	}

	public void setTeach(teach teach) {
		this.teach = teach;
	}
	
}
