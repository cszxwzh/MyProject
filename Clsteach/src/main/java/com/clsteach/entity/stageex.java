package com.clsteach.entity;
/**
 * 
 * @author cszxw
 *用于在cls中查询各个阶段的老师信息的时候使用
 */
public class stageex extends stage {
private teach teach;
private ctrelation ctrelation;
public teach getTeach() {
	return teach;
}
public void setTeach(teach teach) {
	this.teach = teach;
}
public ctrelation getCtrelation() {
	return ctrelation;
}
public void setCtrelation(ctrelation ctrelation) {
	this.ctrelation = ctrelation;
}

}
