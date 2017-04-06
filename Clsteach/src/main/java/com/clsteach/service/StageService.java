package com.clsteach.service;

import java.util.List;

import com.clsteach.entity.stage;
import com.clsteach.entity.stageex;

public interface StageService {
	public int delstage(Integer stageId);
	 public int addstage(stage stage);
	 public stage selById(Integer stageId);
	 public int update(stage stage);
	 public List<stage> selAll();
	 public List<stageex> selectByclsteach(int clsId);
}
