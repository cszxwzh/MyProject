package com.clsteach.entity;

import java.util.List;



public class DataTables {
private  int recordsTotal;
private int recordsFiltered;
@SuppressWarnings("rawtypes")
private List data;

public DataTables() {
	super();
}
@SuppressWarnings("rawtypes")
public DataTables(int recordsTotal, int recordsFiltered, List data) {
	super();
	this.recordsTotal = recordsTotal;
	this.recordsFiltered = recordsFiltered;
	this.data = data;
}
public int getRecordsTotal() {
	return recordsTotal;
}
public void setRecordsTotal(int recordsTotal) {
	this.recordsTotal = recordsTotal;
}
public int getRecordsFiltered() {
	return recordsFiltered;
}
public void setRecordsFiltered(int recordsFiltered) {
	this.recordsFiltered = recordsFiltered;
}
@SuppressWarnings("rawtypes")
public List getData() {
	return data;
}
@SuppressWarnings("rawtypes")
public void setData(List data) {
	this.data = data;
}
@Override
public String toString() {
	return "DataTables [recordsTotal=" + recordsTotal + ", recordsFiltered="
			+ recordsFiltered + ", data=" + data + "]";
}

}
